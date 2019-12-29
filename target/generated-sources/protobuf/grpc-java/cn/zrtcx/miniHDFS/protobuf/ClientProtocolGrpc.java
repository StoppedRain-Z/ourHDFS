package cn.zrtcx.miniHDFS.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.17.1)",
    comments = "Source: ClientProtocol.proto")
public final class ClientProtocolGrpc {

  private ClientProtocolGrpc() {}

  public static final String SERVICE_NAME = "cn.zrtcx.miniHDFS.protobuf.ClientProtocol";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto> getCdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cd",
      requestType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto.class,
      responseType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto> getCdMethod() {
    io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto> getCdMethod;
    if ((getCdMethod = ClientProtocolGrpc.getCdMethod) == null) {
      synchronized (ClientProtocolGrpc.class) {
        if ((getCdMethod = ClientProtocolGrpc.getCdMethod) == null) {
          ClientProtocolGrpc.getCdMethod = getCdMethod = 
              io.grpc.MethodDescriptor.<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cn.zrtcx.miniHDFS.protobuf.ClientProtocol", "cd"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientProtocolMethodDescriptorSupplier("cd"))
                  .build();
          }
        }
     }
     return getCdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto> getLsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ls",
      requestType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto.class,
      responseType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto> getLsMethod() {
    io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto> getLsMethod;
    if ((getLsMethod = ClientProtocolGrpc.getLsMethod) == null) {
      synchronized (ClientProtocolGrpc.class) {
        if ((getLsMethod = ClientProtocolGrpc.getLsMethod) == null) {
          ClientProtocolGrpc.getLsMethod = getLsMethod = 
              io.grpc.MethodDescriptor.<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cn.zrtcx.miniHDFS.protobuf.ClientProtocol", "ls"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientProtocolMethodDescriptorSupplier("ls"))
                  .build();
          }
        }
     }
     return getLsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto> getMkdirMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "mkdir",
      requestType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto.class,
      responseType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto> getMkdirMethod() {
    io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto> getMkdirMethod;
    if ((getMkdirMethod = ClientProtocolGrpc.getMkdirMethod) == null) {
      synchronized (ClientProtocolGrpc.class) {
        if ((getMkdirMethod = ClientProtocolGrpc.getMkdirMethod) == null) {
          ClientProtocolGrpc.getMkdirMethod = getMkdirMethod = 
              io.grpc.MethodDescriptor.<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cn.zrtcx.miniHDFS.protobuf.ClientProtocol", "mkdir"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientProtocolMethodDescriptorSupplier("mkdir"))
                  .build();
          }
        }
     }
     return getMkdirMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get",
      requestType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto.class,
      responseType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto> getGetMethod() {
    io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto> getGetMethod;
    if ((getGetMethod = ClientProtocolGrpc.getGetMethod) == null) {
      synchronized (ClientProtocolGrpc.class) {
        if ((getGetMethod = ClientProtocolGrpc.getGetMethod) == null) {
          ClientProtocolGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cn.zrtcx.miniHDFS.protobuf.ClientProtocol", "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientProtocolMethodDescriptorSupplier("get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto> getPutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put",
      requestType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto.class,
      responseType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto> getPutMethod() {
    io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto> getPutMethod;
    if ((getPutMethod = ClientProtocolGrpc.getPutMethod) == null) {
      synchronized (ClientProtocolGrpc.class) {
        if ((getPutMethod = ClientProtocolGrpc.getPutMethod) == null) {
          ClientProtocolGrpc.getPutMethod = getPutMethod = 
              io.grpc.MethodDescriptor.<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cn.zrtcx.miniHDFS.protobuf.ClientProtocol", "put"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientProtocolMethodDescriptorSupplier("put"))
                  .build();
          }
        }
     }
     return getPutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto> getRmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "rm",
      requestType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto.class,
      responseType = cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto,
      cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto> getRmMethod() {
    io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto> getRmMethod;
    if ((getRmMethod = ClientProtocolGrpc.getRmMethod) == null) {
      synchronized (ClientProtocolGrpc.class) {
        if ((getRmMethod = ClientProtocolGrpc.getRmMethod) == null) {
          ClientProtocolGrpc.getRmMethod = getRmMethod = 
              io.grpc.MethodDescriptor.<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto, cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cn.zrtcx.miniHDFS.protobuf.ClientProtocol", "rm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientProtocolMethodDescriptorSupplier("rm"))
                  .build();
          }
        }
     }
     return getRmMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientProtocolStub newStub(io.grpc.Channel channel) {
    return new ClientProtocolStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientProtocolBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientProtocolBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientProtocolFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientProtocolFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientProtocolImplBase implements io.grpc.BindableService {

    /**
     */
    public void cd(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto> responseObserver) {
      asyncUnimplementedUnaryCall(getCdMethod(), responseObserver);
    }

    /**
     */
    public void ls(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto> responseObserver) {
      asyncUnimplementedUnaryCall(getLsMethod(), responseObserver);
    }

    /**
     */
    public void mkdir(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto> responseObserver) {
      asyncUnimplementedUnaryCall(getMkdirMethod(), responseObserver);
    }

    /**
     */
    public void get(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     */
    public void put(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto> responseObserver) {
      asyncUnimplementedUnaryCall(getPutMethod(), responseObserver);
    }

    /**
     */
    public void rm(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto> responseObserver) {
      asyncUnimplementedUnaryCall(getRmMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto,
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto>(
                  this, METHODID_CD)))
          .addMethod(
            getLsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto,
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto>(
                  this, METHODID_LS)))
          .addMethod(
            getMkdirMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto,
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto>(
                  this, METHODID_MKDIR)))
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto,
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto>(
                  this, METHODID_GET)))
          .addMethod(
            getPutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto,
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto>(
                  this, METHODID_PUT)))
          .addMethod(
            getRmMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto,
                cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto>(
                  this, METHODID_RM)))
          .build();
    }
  }

  /**
   */
  public static final class ClientProtocolStub extends io.grpc.stub.AbstractStub<ClientProtocolStub> {
    private ClientProtocolStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientProtocolStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientProtocolStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientProtocolStub(channel, callOptions);
    }

    /**
     */
    public void cd(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void ls(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void mkdir(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMkdirMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void put(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rm(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRmMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientProtocolBlockingStub extends io.grpc.stub.AbstractStub<ClientProtocolBlockingStub> {
    private ClientProtocolBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientProtocolBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientProtocolBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientProtocolBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto cd(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getCdMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto ls(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getLsMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto mkdir(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getMkdirMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto get(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto put(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getPutMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto rm(cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getRmMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientProtocolFutureStub extends io.grpc.stub.AbstractStub<ClientProtocolFutureStub> {
    private ClientProtocolFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientProtocolFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientProtocolFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientProtocolFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto> cd(
        cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getCdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto> ls(
        cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getLsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto> mkdir(
        cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getMkdirMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto> get(
        cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto> put(
        cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getPutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto> rm(
        cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getRmMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CD = 0;
  private static final int METHODID_LS = 1;
  private static final int METHODID_MKDIR = 2;
  private static final int METHODID_GET = 3;
  private static final int METHODID_PUT = 4;
  private static final int METHODID_RM = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientProtocolImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientProtocolImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CD:
          serviceImpl.cd((cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdRequestProto) request,
              (io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.CdResponseProto>) responseObserver);
          break;
        case METHODID_LS:
          serviceImpl.ls((cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsRequestProto) request,
              (io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.LsResponseProto>) responseObserver);
          break;
        case METHODID_MKDIR:
          serviceImpl.mkdir((cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirRequestProto) request,
              (io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.MkdirResponseProto>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetRequestProto) request,
              (io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.GetResponseProto>) responseObserver);
          break;
        case METHODID_PUT:
          serviceImpl.put((cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutRequestProto) request,
              (io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.PutResponseProto>) responseObserver);
          break;
        case METHODID_RM:
          serviceImpl.rm((cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmRequestProto) request,
              (io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.RmResponseProto>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ClientProtocolBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientProtocolBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.zrtcx.miniHDFS.protobuf.ClientProtocolProbuf.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientProtocol");
    }
  }

  private static final class ClientProtocolFileDescriptorSupplier
      extends ClientProtocolBaseDescriptorSupplier {
    ClientProtocolFileDescriptorSupplier() {}
  }

  private static final class ClientProtocolMethodDescriptorSupplier
      extends ClientProtocolBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientProtocolMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ClientProtocolGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientProtocolFileDescriptorSupplier())
              .addMethod(getCdMethod())
              .addMethod(getLsMethod())
              .addMethod(getMkdirMethod())
              .addMethod(getGetMethod())
              .addMethod(getPutMethod())
              .addMethod(getRmMethod())
              .build();
        }
      }
    }
    return result;
  }
}
