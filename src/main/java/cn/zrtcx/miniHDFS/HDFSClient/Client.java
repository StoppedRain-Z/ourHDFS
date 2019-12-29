package cn.zrtcx.miniHDFS.HDFSClient;

import cn.zrtcx.miniHDFS.Constant.Const;
import cn.zrtcx.miniHDFS.protobuf.ClientProtocolGrpc;
import cn.zrtcx.miniHDFS.protobuf.BaseProtocolProbuf;
import cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Client{
	private static final Logger logger = LoggerFactory.getLogger(Client.class);
	private final ManagedChannel managedChannel;
	
	private static final Scanner scanner = new Scanner(System.in);
	
	private final ClientProtocolGrpc.ClientProtocolBlockingStub clientProtocolBlockingStub;
	
	public Client(String ip,int rpcPort) {
		this.managedChannel = ManagedChannelBuilder
				.forAddress(ip, rpcPort)
				.usePlaintext()
				.build();
	    this.clientProtocolBlockingStub = ClientProtocolGrpc.newBlockingStub(managedChannel);	
	}
	
	public void shutdown() throws InterruptedException{
		managedChannel.shutdown().awaitTermination(5,TimeUnit.SECONDS);
	}
	
	public String cd(String currentPath,String path) {
		if(path.contains(" ")) {
			System.out.println(Const.FALSE_DIR_INFO);
			return currentPath;
		}
		if(path.equals("..")) {
			path = StringUtils.substringBeforeLast(currentPath, "/");
		}else {
			path = path.replaceAll(Const.ILLEGAL_DIR,"_");
			path = currentPath + "/" + path;
		}
		ClientProtocolProbuf.CdRequestProto request = ClientProtocolProbuf.CdRequestProto.newBuilder()
																						 .setPath(BaseProtocolProbuf.PathProto
																								 .newBuilder()
																								 .setSrc(path)
																								 .build())
																						 .build();
		ClientProtocolProbuf.CdResponseProto response;
		try {
			response = clientProtocolBlockingStub.cd(request);
			if(response.getIsSuccessful() == false) {
				System.out.println(Const.FALSE_DIR_INFO);
			}
		}catch(StatusRuntimeException e) {
			logger.warn("RPC failed:{0}",e.getStatus());
			return null;
		}
		return response.getPath().getSrc();
	}
	
	public void ls(String currentPath) {
		ClientProtocolProbuf.LsRequestProto request = ClientProtocolProbuf.LsRequestProto
														.newBuilder()
														.setPath(BaseProtocolProbuf.PathProto
																.newBuilder()
																.setSrc(currentPath)
																.setHasPermission(true)
																.build())
														.build();
		ClientProtocolProbuf.LsResponseProto response;
		try {
			response = clientProtocolBlockingStub.ls(request);
			int count = response.getPathCount();
			String path;
			for(int i = 0; i < count;i++) {
				path = response.getPath(i).getSrc();
				System.out.println(path);
			}
		}catch(StatusRuntimeException e) {
			logger.warn("RPC failed:{0}",e.getStatus());
			return;
		}
		return;
	}
	public void mkdir(String currentPath, String[] paths) {
        ClientProtocolProbuf.MkdirRequestProto.Builder request =
        		ClientProtocolProbuf.MkdirRequestProto
                .newBuilder();
        for (String path : paths) {
            if (path.contains(" ")) {
                System.out.println(Const.FALSE_DIR_INFO);
                return;
            }
            path = path.replaceAll(Const.ILLEGAL_DIR, "_");
            request.addPath(BaseProtocolProbuf.PathProto
                    .newBuilder()
                    .setSrc(currentPath + "/" + path)
                    .setHasPermission(true)
                    .build());
        }
        try {
            clientProtocolBlockingStub.mkdir(request.build());
        } catch (StatusRuntimeException e) {
            logger.warn("RPC failed: {0}", e.getStatus());
            return;
        }
        return;
    }
	public Map<String, String> get(String filename) {
        ClientProtocolProbuf.GetRequestProto request =
        		ClientProtocolProbuf.GetRequestProto
                .newBuilder()
                .setSrc(filename)
                .build();

        Map<String, String> datanodes = new LinkedHashMap<String, String>();

        ClientProtocolProbuf.GetResponseProto response;
        try {
            response = clientProtocolBlockingStub.get(request);
            int count = response.getBlocksCount();
            for (int i = 0; i < count; i++) {
                datanodes.put(response.getBlocks(i).getSrc(),
                    response.getBlocks(i).getId().getIp() + " "
                        + response.getBlocks(i).getId().getSocketPort());
            }
        } catch (StatusRuntimeException e) {
            logger.warn("RPC failed: {0}", e.getStatus());
            return null;
        }
        return datanodes;
    }
	public List<Map<String, String>> put(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println(Const.FALSE_DIR_INFO);
            return null;
        }
        ClientProtocolProbuf.PutRequestProto request =
        		ClientProtocolProbuf.PutRequestProto
                .newBuilder()
                .setSrc(filename)
                .setLength(file.length())
                .build();

        ClientProtocolProbuf.PutResponseProto response;
        List<Map<String, String>> datanodes = new ArrayList<Map<String, String>>();
        Map<String, String> datanode;
        try {
            response = clientProtocolBlockingStub.put(request);
            int count = response.getBlocksCount();
            System.out.println("blockCount:"+count);
            for (int i = 0; i < count; i++) {
                datanode = new HashMap<String, String>();
                datanode.put("Ip", response.getBlocks(i).getId().getIp());
                datanode.put("SocketPort",
                    String.valueOf(response.getBlocks(i).getId().getSocketPort()));
                datanode.put("Filename", response.getBlocks(i).getSrc());
                datanode.put("Offset", String.valueOf(response.getBlocks(i).getOffset()));
                datanode.put("Length", String.valueOf(response.getBlocks(i).getLength()));

                datanodes.add(datanode);
            }
        } catch (StatusRuntimeException e) {
            logger.warn("RPC failed: {0}", e.getStatus());
            return null;
        }
        return datanodes;
    }
	public void rm(String currentPath, String[] paths) {
        ClientProtocolProbuf.RmRequestProto.Builder request =
        		ClientProtocolProbuf.RmRequestProto
                .newBuilder();
        for (String path : paths) {
            if (path.contains(" ")) {
                System.out.println(Const.FALSE_DIR_INFO);
                return;
            }
            path = path.replaceAll(Const.ILLEGAL_DIR, "_");
            request.addPath(BaseProtocolProbuf.PathProto
                    .newBuilder()
                    .setSrc(currentPath + "/" + path)
                    .setHasPermission(true)
                    .build());
        }
        try {
            clientProtocolBlockingStub.rm(request.build());
        } catch (StatusRuntimeException e) {
            logger.warn("RPC failed: {0}", e.getStatus());
            return;
        }
        return;
    }
	public static void main(String[] args) throws Exception{
		Const.NAMENODE_IP = args[0];
		Const.DATANODE_IP = args[1];
		Const.NAMENODE_SRC_PATH = args[2];
		Const.DATANODE_SRC_PATH = args[3];
		Const.RPC_PORT = Integer.valueOf(args[4]);
		Const.SOCKET_PORT = Integer.valueOf(args[5]);
		
		Client client = new Client(Const.NAMENODE_IP,Const.RPC_PORT);
		String cmd;
		String[] cmds;
		String currentPath;
		List<Map<String,String>> upload_datanodes;
		Map<String,String> slaves;
		
		currentPath = Const.NAMENODE_SRC_PATH;
		System.out.println(currentPath + Const.COMMAND_SUFFIX);
		try {
			while(scanner.hasNextLine()) {
				cmd = scanner.nextLine();
				long startTime = System.currentTimeMillis();
				if(cmd.startsWith(Const.COMMAND_ID)) {
					cmd = cmd.substring(Const.COMMAND_ID.length()+1);
					cmds = cmd.split(" ");
					System.out.println(cmds[0]);
					if(cmds[0].contentEquals(Const.CMD_CD)) {
						cmd = cmd.substring(Const.CMD_CD.length()+1);
						currentPath = client.cd(currentPath, cmd);
					}else if(cmd.equals(Const.CMD_LS)) {
						client.ls(currentPath);
					}else if(cmds[0].equals(Const.CMD_MK)) {
						cmd = cmd.substring(Const.CMD_MK.length()+1);
						client.mkdir(currentPath, cmd.split(" "));
					}else if(cmds[0].equals(Const.CMD_RM)) {
						cmd = cmd.substring(Const.CMD_RM.length()+1);
						client.rm(currentPath,cmd.split(" "));
					}else if(cmds[0].equals(Const.CMD_GET)) {
						cmd = cmd.substring(Const.CMD_GET.length()+1);
						slaves = client.get(cmd);
						Download dl = new Download();
						dl.setVariables(slaves, cmd);
						Thread thread = new Thread(dl);
						thread.start();
					}else if(cmds[0].equals(Const.CMD_PUT)) {
						cmd = cmd.substring(Const.CMD_PUT.length()+1);
						upload_datanodes = client.put(cmd);
						Upload up = new Upload();
						up.setVariables(upload_datanodes, cmd);
						Thread thread = new Thread(up);
						thread.start();
					}
				}else {
					System.out.println(Const.FALSE_COMMAND);
				}
				long endTime = System.currentTimeMillis();
				System.out.println("命令执行时间："+(endTime-startTime+"ms"));
				System.out.println(currentPath + Const.COMMAND_SUFFIX);
			}
		}finally {
			client.shutdown();
		}
	}
}

class Download implements Runnable{
	private Map<String,String> slaves;
	private String filename;
	
	public void setVariables(Map<String,String> slaves,String filename) {
		this.slaves = slaves;
		this.filename = filename;
	}
	
	public void run() {
		try {
			System.out.println(filename);
			Iterator<Map.Entry<String, String>> entries;
			Map.Entry<String, String> entry;
			entries = slaves.entrySet().iterator();
			while(entries.hasNext()) {
				entry = entries.next();
				String src = entry.getKey();
				String[] ipAndPort = entry.getValue().split(" ");
				String ip = ipAndPort[0];
				int port = Integer.valueOf(ipAndPort[1]);
				
				File file = new File(filename);
				if(!file.exists()) {
					file.createNewFile();
				}
				Socket socket = new Socket(ip,port);
				DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				DataOutputStream out_file = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file,true)));
				
				out.writeUTF(Const.CMD_GET);
				out.flush();
				
				out.writeUTF(src);
				out.flush();
				
				byte[] bytes = new byte[Const.BYTES_SIZE];
				int length;
				while((length = in.read(bytes)) != -1) {
					out_file.write(bytes,0,length);
					out_file.flush();
				}
				out.close();
				out_file.close();
				in.close();
				socket.close();
			}
		}catch(Exception e) {
			System.err.println(e.getClass().getName() + ":" + e.getMessage() );
		}
	}
}

class Upload implements Runnable {

    private List<Map<String, String>> upload_datanodes;

    private String filename;

    public void setVariables (List<Map<String, String>> upload_datanodes, String filename) {
        this.upload_datanodes = upload_datanodes;
        this.filename = filename;
    }

    public void run() {
        try {
        	long startTime = System.currentTimeMillis();
            for (Map<String, String> datanode : upload_datanodes) {
            	System.out.println("start");
                Socket socket = new Socket(datanode.get("Ip"), Integer.valueOf(datanode.get("SocketPort")));

                File file = new File(filename);
                System.out.println(filename);
                DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));
                DataInputStream in_file = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(file)));

         
                out.writeUTF(Const.CMD_PUT);
                out.flush();

                String src = datanode.get("Filename");
                out.writeUTF(src);
                out.flush();

                long offset = Long.valueOf(datanode.get("Offset"));
                long length = Long.valueOf(datanode.get("Length"));
                long currOffset = 0L;
                int tmpLength;
                byte[] bytes = new byte[Const.BYTES_SIZE];

                while ((tmpLength = in_file.read(bytes)) != -1) {
                    if (currOffset + tmpLength < offset) {
                    } else if (currOffset < offset) {
                        out.write(bytes, (int)(offset - currOffset),
                            Math.min((int)(currOffset + tmpLength - offset), tmpLength));
                    } else if (currOffset + tmpLength < offset + length) {
                        out.write(bytes, 0, tmpLength);
                    } else if (currOffset < offset + length) {
                        out.write(bytes, 0,
                            Math.min((int)(offset + length - currOffset), tmpLength));
                    } else {
                        break;
                    }
                    currOffset += tmpLength;
                    out.flush();
                }

                out.close();
                in_file.close();
                socket.close();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("put花费时间：" + (endTime-startTime) + "ms");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}