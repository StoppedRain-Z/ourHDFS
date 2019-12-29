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
    comments = "Source: DatanodeProtocol.proto")
public final class DatanodeProtocolGrpc {

  private DatanodeProtocolGrpc() {}

  public static final String SERVICE_NAME = "cn.zrtcx.miniHDFS.protobuf.DatanodeProtocol";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto,
      cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto.class,
      responseType = cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto,
      cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto> getRegisterMethod() {
    io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto, cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto> getRegisterMethod;
    if ((getRegisterMethod = DatanodeProtocolGrpc.getRegisterMethod) == null) {
      synchronized (DatanodeProtocolGrpc.class) {
        if ((getRegisterMethod = DatanodeProtocolGrpc.getRegisterMethod) == null) {
          DatanodeProtocolGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto, cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cn.zrtcx.miniHDFS.protobuf.DatanodeProtocol", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto.getDefaultInstance()))
                  .setSchemaDescriptor(new DatanodeProtocolMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto,
      cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto> getHeartbeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "heartbeat",
      requestType = cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto.class,
      responseType = cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto,
      cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto> getHeartbeatMethod() {
    io.grpc.MethodDescriptor<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto, cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto> getHeartbeatMethod;
    if ((getHeartbeatMethod = DatanodeProtocolGrpc.getHeartbeatMethod) == null) {
      synchronized (DatanodeProtocolGrpc.class) {
        if ((getHeartbeatMethod = DatanodeProtocolGrpc.getHeartbeatMethod) == null) {
          DatanodeProtocolGrpc.getHeartbeatMethod = getHeartbeatMethod = 
              io.grpc.MethodDescriptor.<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto, cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cn.zrtcx.miniHDFS.protobuf.DatanodeProtocol", "heartbeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto.getDefaultInstance()))
                  .setSchemaDescriptor(new DatanodeProtocolMethodDescriptorSupplier("heartbeat"))
                  .build();
          }
        }
     }
     return getHeartbeatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DatanodeProtocolStub newStub(io.grpc.Channel channel) {
    return new DatanodeProtocolStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatanodeProtocolBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DatanodeProtocolBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DatanodeProtocolFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DatanodeProtocolFutureStub(channel);
  }

  /**
   */
  public static abstract class DatanodeProtocolImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void heartbeat(cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto> responseObserver) {
      asyncUnimplementedUnaryCall(getHeartbeatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto,
                cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getHeartbeatMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto,
                cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto>(
                  this, METHODID_HEARTBEAT)))
          .build();
    }
  }

  /**
   */
  public static final class DatanodeProtocolStub extends io.grpc.stub.AbstractStub<DatanodeProtocolStub> {
    private DatanodeProtocolStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DatanodeProtocolStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatanodeProtocolStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DatanodeProtocolStub(channel, callOptions);
    }

    /**
     */
    public void register(cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void heartbeat(cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto request,
        io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHeartbeatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DatanodeProtocolBlockingStub extends io.grpc.stub.AbstractStub<DatanodeProtocolBlockingStub> {
    private DatanodeProtocolBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DatanodeProtocolBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatanodeProtocolBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DatanodeProtocolBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto register(cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto heartbeat(cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto request) {
      return blockingUnaryCall(
          getChannel(), getHeartbeatMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DatanodeProtocolFutureStub extends io.grpc.stub.AbstractStub<DatanodeProtocolFutureStub> {
    private DatanodeProtocolFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DatanodeProtocolFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatanodeProtocolFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DatanodeProtocolFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto> register(
        cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto> heartbeat(
        cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto request) {
      return futureUnaryCall(
          getChannel().newCall(getHeartbeatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_HEARTBEAT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DatanodeProtocolImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DatanodeProtocolImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterRequestProto) request,
              (io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.RegisterResponseProto>) responseObserver);
          break;
        case METHODID_HEARTBEAT:
          serviceImpl.heartbeat((cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatRequestProto) request,
              (io.grpc.stub.StreamObserver<cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.HeartbeatResponseProto>) responseObserver);
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

  private static abstract class DatanodeProtocolBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DatanodeProtocolBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.zrtcx.miniHDFS.protobuf.DatanodeProtocolProbuf.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DatanodeProtocol");
    }
  }

  private static final class DatanodeProtocolFileDescriptorSupplier
      extends DatanodeProtocolBaseDescriptorSupplier {
    DatanodeProtocolFileDescriptorSupplier() {}
  }

  private static final class DatanodeProtocolMethodDescriptorSupplier
      extends DatanodeProtocolBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DatanodeProtocolMethodDescriptorSupplier(String methodName) {
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
      synchronized (DatanodeProtocolGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DatanodeProtocolFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getHeartbeatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
