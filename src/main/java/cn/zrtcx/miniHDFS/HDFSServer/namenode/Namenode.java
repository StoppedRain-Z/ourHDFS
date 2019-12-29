package cn.zrtcx.miniHDFS.HDFSServer.namenode;

import cn.zrtcx.miniHDFS.Constant.*;
import cn.zrtcx.miniHDFS.protobuf.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.*;

public class Namenode{
	private Server server;
	private void start() throws IOException{
		System.out.println(Const.NAMENODE_GREETING);
		server = ServerBuilder.forPort(Const.RPC_PORT)
							  .addService(new ClientProtocolImpl())
							  .addService(new DatanodeProtocolImpl())
							  .build()
							  .start();
		System.out.println(Const.NAMENODE_START);
		File dir = new File(Const.NAMENODE_SRC_PATH);
		if(!dir.exists()) {
			dir.mkdir();
			System.out.println("namenode catagory creats successfully");
		}
		File datanodeDir = new File(Const.DATANODE_SRC_PATH);
		if(!datanodeDir.exists()) {
			datanodeDir.mkdir();
			System.out.println("datanode catagory creats successfully");
		}
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println(Const.NAMENODE_ERROR);
				Namenode.this.stop();
				System.err.println(Const.NAMENODE_CLOSE);
			}
		});
	}
	
	private void stop() {
		if(server != null) {
			server.shutdown();
		}
	}
	
	private void blockUntilShutdown() throws InterruptedException{
		if(server != null) {
			server.awaitTermination();
		}
	}
	
	public static void main(String[] args) throws IOException,InterruptedException{
		Const.NAMENODE_IP = args[0];
		Const.DATANODE_IP = args[1];
		Const.NAMENODE_SRC_PATH = args[2];
		Const.DATANODE_SRC_PATH = args[3];
		Const.RPC_PORT = Integer.valueOf(args[4]);
		Const.SOCKET_PORT = Integer.valueOf(args[5]);
		
		System.out.println(Const.NAMENODE_SRC_PATH);
		System.out.println(Const.DATANODE_SRC_PATH);
		
		final Namenode namenode = new Namenode();
		namenode.start();
		namenode.blockUntilShutdown();
	}
}