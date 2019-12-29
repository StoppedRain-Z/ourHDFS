package cn.zrtcx.miniHDFS.HDFSServer.datanode;

import cn.zrtcx.miniHDFS.Constant.*;
import cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolGrpc;
import cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf;
import cn.zrtcx.miniHDFS.protobuf.BaseProtocolProbuf;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Datanode {
    private static final Logger LOGGER = LoggerFactory.getLogger(Datanode.class);

    private final ManagedChannel managedChannel;
    private final DatanodeProtocolGrpc.DatanodeProtocolBlockingStub
        datanodeProtocolBlockingStub;

    //public String namenode_ip;  //namenode_ip
    public String ip;	//datanode_ip
    public int rpcPort;
    public int socketPort;

    private boolean hasRegistered;

    public Datanode(String ip,int rpcPort, int socketRpc) {
        this.managedChannel = ManagedChannelBuilder
                .forAddress(Const.NAMENODE_IP, rpcPort)
                .usePlaintext()
                .build();
        this.datanodeProtocolBlockingStub =
        		DatanodeProtocolGrpc.newBlockingStub(managedChannel);
        this.ip = ip;
        this.rpcPort = rpcPort;
        this.socketPort = socketRpc;
        File datanodeDir = new File(Const.DATANODE_SRC_PATH);
		if(!datanodeDir.exists()) {
			datanodeDir.mkdir();
			System.out.println("datanode catagory creats successfully");
		}
    }

    public void register() {
    	DatanodeProtocolProbuf.RegisterRequestProto request =
    			DatanodeProtocolProbuf.RegisterRequestProto
                .newBuilder()
                .setId(BaseProtocolProbuf.IdProto
                        .newBuilder()
                        .setIp(ip)
                        .setRpcPort(rpcPort)
                        .setSocketPort(socketPort)
                        .build())
                .build();
        DatanodeProtocolProbuf.RegisterResponseProto response;
        try {
        	
            response = datanodeProtocolBlockingStub.register(request);
            hasRegistered = response.getIsSuccessful();
            System.out.println(hasRegistered);
        } catch (StatusRuntimeException e) {
            LOGGER.warn("RPC failed: {123}", e.getStatus());
            return;
        }
        return;
    }

    public boolean heartbeat() {
    	DatanodeProtocolProbuf.HeartbeatRequestProto request =
    			DatanodeProtocolProbuf.HeartbeatRequestProto
                .newBuilder()
                .setId(BaseProtocolProbuf.IdProto
                        .newBuilder()
                        .setIp(ip)
                        .setRpcPort(rpcPort)
                        .setSocketPort(socketPort)
                        .build())
                .setHasRegistered(hasRegistered)
                .build();
    	DatanodeProtocolProbuf.HeartbeatResponseProto response;
        try {
            response = datanodeProtocolBlockingStub.heartbeat(request);
        } catch (StatusRuntimeException e) {
            LOGGER.warn("RPC failed: {456}", e.getStatus());
            return false;
        }
        return response.getIsSuccessful();
    }

    public static void main(String[] args) throws Exception {
    	Const.NAMENODE_IP = args[0];
		Const.DATANODE_IP = args[1];
		Const.NAMENODE_SRC_PATH = args[2];
		Const.DATANODE_SRC_PATH = args[3];
		Const.RPC_PORT = Integer.valueOf(args[4]);
		Const.SOCKET_PORT = Integer.valueOf(args[5]);

        Datanode datanode = new Datanode(Const.DATANODE_IP,
            Const.RPC_PORT,
            Const.SOCKET_PORT);

        try {
            datanode.register();

            Heartbeat heartbeat = new Heartbeat();
            heartbeat.setDatanode(datanode);
            Thread threadHeartbeat = new Thread(heartbeat);
            threadHeartbeat.start();

            Server server = new Server();
            server.setDatanode(datanode);
            Thread threadServer = new Thread(server);
            threadServer.start();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}

class Heartbeat implements Runnable {

    private Datanode datanode;

    public void setDatanode(Datanode datanode) {
        this.datanode = datanode;
    }

    public void run() {
        while (true) {
            try {
                datanode.heartbeat();
                Thread.sleep(Const.HEARTBEAT);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
    }
}

class Server implements Runnable {

    private Datanode datanode;

    public void setDatanode(Datanode datanode) {
        this.datanode = datanode;
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(datanode.socketPort));

            while (true) {
                Socket socket = serverSocket.accept();

                ServerHandler ServerHandler = new ServerHandler();
                ServerHandler.setVariables(datanode, socket);
                Thread threadUploadServerHandler = new Thread(ServerHandler);
                threadUploadServerHandler.start();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}

class ServerHandler implements Runnable {

    private Datanode datanode;

    private Socket socket;

    public void setVariables(Datanode datanode, Socket socket) {
        this.datanode = datanode;
        this.socket = socket;
    }

    public void run() {
        try {
            // receive filename
            DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream()));

            String op = dataInputStream.readUTF();
            System.out.println(op);
            String filename = dataInputStream.readUTF();
            System.out.println(filename);
            if (op.equals(Const.CMD_PUT)) {
        		System.out.println(Const.DATANODE_SRC_PATH + "/" + filename);
                File file = new File(Const.DATANODE_SRC_PATH + "/" + filename);
                if (!file.exists()) {
                    file.createNewFile();
                }

                DataOutputStream fileDataOutputStream = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(file)));

                byte[] bytes = new byte[Const.BYTES_SIZE];
                int length;

                while ((length = dataInputStream.read(bytes)) != -1) {
                    fileDataOutputStream.write(bytes, 0, length);
                    fileDataOutputStream.flush();
                }

                fileDataOutputStream.close();
                dataInputStream.close();
            } else if (op.equals(Const.CMD_GET)){
                File file = new File(Const.DATANODE_SRC_PATH + "/" + filename);
                if (!file.exists()) {
                    file.createNewFile();
                }
                DataInputStream fileDataInputStream = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(file)));

                byte[] bytes = new byte[Const.BYTES_SIZE];
                int length;

                while ((length = fileDataInputStream.read(bytes)) != -1) {
                    dataOutputStream.write(bytes, 0, length);
                    dataOutputStream.flush();
                }

                fileDataInputStream.close();
                dataOutputStream.close();
            }

            socket.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
