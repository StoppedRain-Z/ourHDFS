package cn.zrtcx.miniHDFS.protobuf;

import cn.zrtcx.miniHDFS.Constant.*;
import io.grpc.stub.StreamObserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;


public class DatanodeProtocolImpl extends DatanodeProtocolGrpc.DatanodeProtocolImplBase{

    private List<String> datanodes = new LinkedList<String>();

    @Override
    public void register(DatanodeProtocolProbuf.RegisterRequestProto request, StreamObserver<DatanodeProtocolProbuf.RegisterResponseProto> responseObserver) {
        boolean isSuccessful = true;
        String ip = request.getId().getIp();
        int rpcPort = request.getId().getRpcPort();
        int socketPort = request.getId().getSocketPort();
        String[] info;
        for (String value : datanodes) {
            info = value.split(" ");
            if (info[1].equals(String.valueOf(rpcPort)) && info[2].equals(String.valueOf(socketPort))) {
                isSuccessful = false;
                break;
            }
        }
        if (isSuccessful) {
            datanodes.add(ip + " " + rpcPort + " " + socketPort);
        }
        try {
            File slaveList = new File(Const.NAMENODE_SRC_PATH + "/" + Const.DATANODE_LIST);
            if (!slaveList.exists()) {
                slaveList.createNewFile();
            }
            FileWriter fw = new FileWriter(slaveList);
            BufferedWriter writer = new BufferedWriter(fw);
            for (String value : datanodes) {
                writer.write(value + "\r\n");
                System.out.println(value);
            }
            writer.close();
            fw.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("register successfully");

        DatanodeProtocolProbuf.RegisterResponseProto response = DatanodeProtocolProbuf.RegisterResponseProto
                .newBuilder()
                .setIsSuccessful(isSuccessful)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void heartbeat(DatanodeProtocolProbuf.HeartbeatRequestProto request, StreamObserver<DatanodeProtocolProbuf.HeartbeatResponseProto> responseObserver) {
        boolean isSuccessful = false;
        String ip = request.getId().getIp();
        int rpcPort = request.getId().getRpcPort();
        int socketPort = request.getId().getSocketPort();
        boolean hasRegistered = request.getHasRegistered();
        String[] info;
        for (String value : datanodes) {
            info = value.split(" ");
            if (hasRegistered && info[0].equals(ip) && info[1].equals(String.valueOf(rpcPort)) && info[2].equals(String.valueOf(socketPort))) {
                isSuccessful = true;
                break;
            }
        }
        System.out.println("heartbeat successfully");
        DatanodeProtocolProbuf.HeartbeatResponseProto response = DatanodeProtocolProbuf.HeartbeatResponseProto
                .newBuilder()
                .setIsSuccessful(isSuccessful)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
