# ourHDFS
mini implemention of HDFS

HDFS是Hadoop的分布式文件系统，它被设计成适合在通用硬件上运行。HDFS是一个高度容错性的系统，适合部署在廉价的机器上且能提供高吞吐量的数据访问，非常适合大规模数据集上的应用。
我们实现了简易版HDFS，功能如下：
## 实现功能
节点间网络通讯：
Client与Namenode之间的RPC通信
Namenode与Datanode之间的RPC通信
Client与Datanode之间的socket通信
### 实现思路：
通过ClientProtocol封装Client与Namenode之间的命令函数，如cd、mkdir、ls、rm、get、put等；通过DatanodeProtocol封装Datanode与Namenode之间的通信函数，如register（Datanode注册）、heartbeat（心跳函数）等。随后在Namenode中绑定ClientProtocol和DataNodeProtocol协议，以此来达成与两者的沟通。同时，Datanode中建立了serversocket连接，随时接受来自client的连接请求，进行文件的上传与下载。
### 存储数据
分块存储、副本存储
### 实现思路：
大文件在Datanode上的存储被切割为块：当Client向Namenode发出上传文件请求时，ClientProtocol会根据文件大小对文件进行分块（设置block大小为128M），而后将根据块对应在文件中的位置对返回给Client一个Filename（重设为filename_block(i)），IP，socketPort三元组列表，随后Client将于对应IP、SocketPort的Datanode进行连接进行文件的传输。
副本存储：设置Replication_factor默认为3，即在不同Datanode上共存储3份副本，本mini-HDFS设置为当Client向Datanode均发送完成文件后，才会向Client返回OK提示，进行下个命令的输入与处理。
### 文件上传、下载、查询、删除命令实现
共实现命令：cd、mkdir、ls、rm、get、put
### 实现思路：
均通过Request与Response进行，调用ClientProtocol中相应函数。

cd：仅支持/home/ubuntu/namenode/下文件夹的进入，判定File(path）对象是否存在。

mkdir：仅支持/home/ubuntu/namenode/下文件或文件夹的创建，判断文件/文件夹是否存在，若不存在，则创建。

ls：仅支持/home/ubuntu/namenode/下文件夹的查询操作，创建File(currentPath)对象，对列表下的所有文件进行展示。

rm：仅支持/home/ubuntu/namenode/下文件夹的删除操作，创建File(path)对象，对目录惊醒ForeceDelete(),对文件进行Delete()

get：client将文件名传递给namenode，clientprotocol查询blcoklist文件对还有该filename的block文件列表传递给client，并同时将存储有block的datanode相关信息返回给client，client与datanode进行连接，发送get请求，进行文件的传输。

put：将文件上传至/home/ubuntu/namenode下，client将文件名和文件长度通过request传递给namenode，ClientProtocol根据文件长度、block大小（128M）对文件进行切分，而后将切分后形成的结果返回给client，同时返回需要存储的datanode的相关信息，随后client与datanode连接，发送put请求，进行文件的传输。
## 运行说明
进入miniHDFS/bin目录下
在Namenode服务器上运行
sh namenode.sh
在Datanode服务器上运行
sh datanode.sh
在客户端运行
sh client.sh
即可在客户端输入指令，执行命令。

命令使用方法：

键入 hdfs cd <路径> ：进入文件夹
键入 hdfs mkdir <路径> ：创建文件夹
键入 hdfs ls：显示当前路径下目录信息
键入 hdfs rm <路径> ：删除文件/文件夹
键入 hdfs get <文件路径> <路径> ：下载文件到客户端
键入 hdfs put <文件路径> <路径> ：上传文件到hdfs
