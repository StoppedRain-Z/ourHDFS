#!/bin/bash

namenode_ip=`grep -o "<namenode_ip>[^<]*</namenode_ip>" config.xml | sed -e "s/<namenode_ip>\(.*\)<\/namenode_ip>/\1/"`
datanode_ip=`grep -o "<datanode_ip>[^<]*</datanode_ip>" config.xml | sed -e "s/<datanode_ip>\(.*\)<\/datanode_ip>/\1/"`
namenode_src_path=`grep -o "<namenode_src_path>[^<]*</namenode_src_path>" config.xml | sed -e "s/<namenode_src_path>\(.*\)<\/namenode_src_path>/\1/"`
datanode_src_path=`grep -o "<datanode_src_path>[^<]*</datanode_src_path>" config.xml | sed -e "s/<datanode_src_path>\(.*\)<\/datanode_src_path>/\1/"`
rpc_port=`grep -o "<rpc_port>[^<]*</rpc_port>" config.xml | sed -e "s/<rpc_port>\(.*\)<\/rpc_port>/\1/"`
socket_port=`grep -o "<socket_port>[^<]*</socket_port>" config.xml | sed -e "s/<socket_port>\(.*\)<\/socket_port>/\1/"`

java -cp miniHDFS-0.0.1-SNAPSHOT.jar cn.zrtcx.miniHDFS.HDFSServer.datanode.Datanode ${namenode_ip} ${datanode_ip} ${namenode_src_path} ${datanode_src_path} ${rpc_port} ${socket_port}