package cn.zrtcx.miniHDFS.Constant;

public class Const{
	public static String NAMENODE_IP;
    public static String DATANODE_IP;
    public static String CLIENT_IP;
    public static int RPC_PORT;
    public static int SOCKET_PORT;

    //当前工程路径
    public static String NAMENODE_SRC_PATH = "";
    public static String DATANODE_SRC_PATH = "";

    public static final String COMMAND_SUFFIX = ">";
    public static final String COMMAND_ID = "hdfs";

    public static final String BLOCK_SPACE = "#";
    public static final String ILLEGAL_DIR = "[\\\\\\\\/:*?\\\"<>|]";
    public static final String NAMENODE_GREETING = "Namenode staring... ";
    public static final String NAMENODE_START = "Namenode starts successfully.";
    public static final String NAMENODE_ERROR = "Namenode starts error.";
    public static final String NAMENODE_CLOSE = "Namenode close.";
    public static final String CLIENT_GREETING = "HDFSClient staring...";
    public static final String FALSE_COMMAND = "Input command not exists,please try agian.";
    public static final String FALSE_DIR_INFO = "Input filename or dir invalid.";


    public static final String CMD_CD = "cd";
    public static final String CMD_LS = "ls";
    public static final String CMD_MK = "mkdir";
    public static final String CMD_GET = "get";
    public static final String CMD_PUT = "put";
    public static final String CMD_RM = "rm";

    public static final long BLOCK_SIZE = 134217728;  //128MB;
    public static int REPLICATION_FACTOR = 3;
    public static final int HEARTBEAT = 5000; //ms
    public static final int BYTES_SIZE = 4096;

    public static final String LOG = "Log";

    //datanode: ip + rpcPort + socketPort
    public static final String DATANODE_LIST = "DatanodeList.txt";
    //datanode + src + offset + length
    public static final String BLOCK_LIST = "BlockList.txt";
}