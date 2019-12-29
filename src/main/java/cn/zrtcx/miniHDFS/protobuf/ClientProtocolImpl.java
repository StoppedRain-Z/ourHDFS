package cn.zrtcx.miniHDFS.protobuf;

import cn.zrtcx.miniHDFS.Constant.*;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.*;

import org.apache.commons.io.FileUtils;

public class ClientProtocolImpl extends ClientProtocolGrpc.ClientProtocolImplBase{
	@Override
	public void cd(ClientProtocolProbuf.CdRequestProto request,StreamObserver<ClientProtocolProbuf.CdResponseProto> responseObserver) {
		String basePath = Const.NAMENODE_SRC_PATH;
		String path = request.getPath().getSrc();
		File file = new File(path);
        Boolean isSuccessful = true;
        if (!file.exists()) {
            path = StringUtils.substringBeforeLast(path, "/");
            isSuccessful = false;
        }
        if (path.compareTo(basePath) < 0) {
            path = basePath;
            isSuccessful = false;
        }
        ClientProtocolProbuf.CdResponseProto response = ClientProtocolProbuf.CdResponseProto
        												.newBuilder()
        												.setPath(BaseProtocolProbuf.PathProto
        														.newBuilder()
        														.setSrc(path)
        														.setHasPermission(true)
        														.build())
        												.setIsSuccessful(isSuccessful)
        												.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
		
	}
	@Override
	public void ls(ClientProtocolProbuf.LsRequestProto request, StreamObserver<ClientProtocolProbuf.LsResponseProto> responseObserver) {
        String path = request.getPath().getSrc();
        File dirs = new File(path);
        System.out.println("src:"+path+",open ok");
        ClientProtocolProbuf.LsResponseProto.Builder response = ClientProtocolProbuf.LsResponseProto
                .newBuilder();

        for (String dir : dirs.list()) {
            response.addPath(BaseProtocolProbuf.PathProto
                    .newBuilder()
                    .setSrc(dir)
                    .setHasPermission(true)
                    .build());
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
	@Override
    public void mkdir(ClientProtocolProbuf.MkdirRequestProto request, StreamObserver<ClientProtocolProbuf.MkdirResponseProto> responseObserver) {
		ClientProtocolProbuf.MkdirResponseProto response = ClientProtocolProbuf.MkdirResponseProto
                .newBuilder()
                .build();

        int count = request.getPathCount();
        File file;
        String path;
        for (int i = 0; i < count; i++) {
            path = request.getPath(i).getSrc();
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
	@Override
    public void rm(ClientProtocolProbuf.RmRequestProto request, StreamObserver<ClientProtocolProbuf.RmResponseProto> responseObserver) {
		ClientProtocolProbuf.RmResponseProto.Builder response = ClientProtocolProbuf.RmResponseProto
                .newBuilder();
        int count = request.getPathCount();
        File file;
        String path;
        boolean isSuccessful = true;
        for (int i = 0; i < count; i++) {
            path = request.getPath(i).getSrc();
            file = new File(path);
            if (!file.exists()) {
                isSuccessful = false;
            } else {
            	System.gc();
            	try {
            		FileUtils.forceDelete(file);
                }catch(Exception e) {
                	System.err.println(e.getMessage());
                }
            }
        }
        response.setIsSuccessful(isSuccessful);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
	@Override
    public void get(ClientProtocolProbuf.GetRequestProto request, StreamObserver<ClientProtocolProbuf.GetResponseProto> responseObserver) {
		ClientProtocolProbuf.GetResponseProto.Builder response = ClientProtocolProbuf.GetResponseProto
                .newBuilder();

        BufferedReader reader;

        String strLine;

        String filename = StringUtils.substringBefore(request.getSrc(), ".");
        System.out.println(filename);

        Map<String, String> infos = new LinkedHashMap<String, String>();
        Iterator<Map.Entry<String, String>> entries;
        Map.Entry<String, String> entry;
        List<String> pickedBlocks = new ArrayList<String>();

        try {
            File block_list = new File(Const.NAMENODE_SRC_PATH + "/" + Const.BLOCK_LIST);
            if (!block_list.exists()) {
            	block_list.createNewFile();
            }

            reader = new BufferedReader(new FileReader(block_list));

            while ((strLine = reader.readLine()) != null) {
                infos.put(strLine.split(Const.BLOCK_SPACE)[1], strLine.split(Const.BLOCK_SPACE)[0].split(" ")[0] + " " + strLine.split(Const.BLOCK_SPACE)[0].split(" ")[2]);
            }

            entries = infos.entrySet().iterator();

            while (entries.hasNext()) {
                entry = entries.next();
                System.out.println(entry.getKey());
                if (!StringUtils.substringBefore(entry.getKey(), "_").equals(filename)) {
                    continue;
                }
                if (pickedBlocks.contains(entry.getKey())) {
                    continue;
                }

                response.addBlocks(BaseProtocolProbuf.BlockProto
                        .newBuilder()
                        .setId(BaseProtocolProbuf.IdProto
                                .newBuilder()
                                .setIp(entry.getValue().split(" ")[0])
                                .setSocketPort(Integer.valueOf(entry.getValue().split(" ")[1]))
                                .build())
                        .setSrc(entry.getKey())
                        .build());

                pickedBlocks.add(entry.getKey());
            }

            reader.close();
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
	@Override
    public void put(ClientProtocolProbuf.PutRequestProto request, StreamObserver<ClientProtocolProbuf.PutResponseProto> responseObserver) {
		ClientProtocolProbuf.PutResponseProto.Builder response = ClientProtocolProbuf.PutResponseProto
                .newBuilder();

        // datanodes (ip + rpcPort + socketPort)
        List<String> datanodes = new LinkedList<String>();
        //(datanode, memory)
        Map<String, Long> memories = new HashMap<String, Long>();

        BufferedReader reader;
        BufferedWriter writer;

        String strLine;

        String[] info;
        String filename;

        String tmpNode;
        long tmpMemory;
        long baseMemory;

        Map<String, Long> pickedSlaves;
        String currDatanode;

        Iterator<Map.Entry<String, Long>> entries;
        Map.Entry<String, Long> entry;
        String oldname = request.getSrc();
        String filena = oldname.substring(oldname.lastIndexOf('/')+1);
        System.out.println(filena);
        try {
            File slavesList = new File(Const.NAMENODE_SRC_PATH + "/" + Const.DATANODE_LIST);
            if (!slavesList.exists()) {
                slavesList.createNewFile();
                System.out.println("create");
            }
            
            File newfile = new File(Const.NAMENODE_SRC_PATH + "/" + filena);
            if(!newfile.exists()) {
            	newfile.createNewFile();
            }
            System.out.println("Start");
            reader = new BufferedReader(new FileReader(slavesList));
            System.out.println("ok");
            while ((strLine = reader.readLine()) != null) {
                datanodes.add(strLine);
                System.out.println(strLine);
            }

            for (String datanode : datanodes) {
                memories.put(datanode, 0L);
            }

            reader.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        int nodeCount = datanodes.size();
        int blockCount = (int)(Math.ceil((float)request.getLength() / (float)Const.BLOCK_SIZE));
        int replicationCount = Math.min(Const.REPLICATION_FACTOR, nodeCount);
        System.out.println("blockCount:" + blockCount);
        try {
            File block_list = new File(Const.NAMENODE_SRC_PATH + "/" + Const.BLOCK_LIST);
            boolean isExists = true;
            if (!block_list.exists()) {
            	isExists = false;
                block_list.createNewFile();
            }
            System.out.println("blocklist open");
            reader = new BufferedReader(new FileReader(block_list));
            if(isExists == false)
            while ((strLine = reader.readLine()) != null) {

                info = strLine.split(Const.BLOCK_SPACE);
                System.out.println(info[0]+" "+info[3]);
                tmpMemory = memories.get(info[0]) + Long.valueOf(info[3]);
                memories.put(info[0], tmpMemory);
            }

            reader.close();

            writer = new BufferedWriter(new FileWriter(block_list, true));

            for (int i = 0; i < blockCount; i++) {
                baseMemory = Long.MAX_VALUE;
                pickedSlaves = new HashMap<String, Long>();
                currDatanode = null;
                entries = memories.entrySet().iterator();

                while (entries.hasNext()) {
                    entry = entries.next();
                    tmpNode = entry.getKey();
                    tmpMemory = entry.getValue();
                    if (pickedSlaves.size() < replicationCount) {
                    	System.out.println("size small");
                        pickedSlaves.put(tmpNode, tmpMemory);
                        if ((tmpMemory < baseMemory && baseMemory == Long.MAX_VALUE) || tmpMemory >= baseMemory) {
                            baseMemory = tmpMemory;
                            currDatanode = tmpNode;
                        }
                        continue;
                    }
                    if (tmpMemory < baseMemory) {
                        pickedSlaves.remove(currDatanode);
                        pickedSlaves.put(tmpNode, tmpMemory);
                        baseMemory = tmpMemory;
                        currDatanode = tmpNode;
                    }
                }

                entries = pickedSlaves.entrySet().iterator();

                while (entries.hasNext()) {
                    entry = entries.next();
                    tmpNode = entry.getKey();
                    System.out.println(tmpNode);
                    info = tmpNode.split(" ");

                    if (i == blockCount - 1) {
                        tmpMemory = entry.getValue() + request.getLength() - (blockCount - 1) * Const.BLOCK_SIZE;
                    } else {
                        tmpMemory = entry.getValue() + Const.BLOCK_SIZE;
                    }
                    memories.put(tmpNode, tmpMemory);


                    filename = StringUtils.substringBeforeLast(filena, ".")
                            + "_" + i + "_" + info[2] + "."
                            + StringUtils.substringAfterLast(filena, ".");
                    System.out.println(filename);
                    writer.write(tmpNode + Const.BLOCK_SPACE
                            + filename + Const.BLOCK_SPACE
                            + i * Const.BLOCK_SIZE + Const.BLOCK_SPACE
                            + (tmpMemory - entry.getValue())
                            + "\r\n");

                    response.addBlocks(BaseProtocolProbuf.BlockProto
                            .newBuilder()
                            .setId(BaseProtocolProbuf.IdProto
                                    .newBuilder()
                                    .setIp(info[0])
                                    .setSocketPort(Integer.valueOf(info[2]))
                                    .build())
                            .setSrc(filename)
                            .setOffset(i * Const.BLOCK_SIZE)
                            .setLength(tmpMemory - entry.getValue())
                            .build());
                }
            }

            writer.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

}