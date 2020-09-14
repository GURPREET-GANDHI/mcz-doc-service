package com.mcz.docmanager.grpc;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: document.proto")
public final class documentGrpc {

  private documentGrpc() {}

  public static final String SERVICE_NAME = "document";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mcz.docmanager.grpc.Document.StoreRequest,
      com.mcz.docmanager.grpc.Document.APIResponse> getStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "store",
      requestType = com.mcz.docmanager.grpc.Document.StoreRequest.class,
      responseType = com.mcz.docmanager.grpc.Document.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mcz.docmanager.grpc.Document.StoreRequest,
      com.mcz.docmanager.grpc.Document.APIResponse> getStoreMethod() {
    io.grpc.MethodDescriptor<com.mcz.docmanager.grpc.Document.StoreRequest, com.mcz.docmanager.grpc.Document.APIResponse> getStoreMethod;
    if ((getStoreMethod = documentGrpc.getStoreMethod) == null) {
      synchronized (documentGrpc.class) {
        if ((getStoreMethod = documentGrpc.getStoreMethod) == null) {
          documentGrpc.getStoreMethod = getStoreMethod = 
              io.grpc.MethodDescriptor.<com.mcz.docmanager.grpc.Document.StoreRequest, com.mcz.docmanager.grpc.Document.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "document", "store"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mcz.docmanager.grpc.Document.StoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mcz.docmanager.grpc.Document.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new documentMethodDescriptorSupplier("store"))
                  .build();
          }
        }
     }
     return getStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mcz.docmanager.grpc.Document.UpdateRequest,
      com.mcz.docmanager.grpc.Document.APIResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = com.mcz.docmanager.grpc.Document.UpdateRequest.class,
      responseType = com.mcz.docmanager.grpc.Document.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mcz.docmanager.grpc.Document.UpdateRequest,
      com.mcz.docmanager.grpc.Document.APIResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.mcz.docmanager.grpc.Document.UpdateRequest, com.mcz.docmanager.grpc.Document.APIResponse> getUpdateMethod;
    if ((getUpdateMethod = documentGrpc.getUpdateMethod) == null) {
      synchronized (documentGrpc.class) {
        if ((getUpdateMethod = documentGrpc.getUpdateMethod) == null) {
          documentGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.mcz.docmanager.grpc.Document.UpdateRequest, com.mcz.docmanager.grpc.Document.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "document", "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mcz.docmanager.grpc.Document.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mcz.docmanager.grpc.Document.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new documentMethodDescriptorSupplier("update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static documentStub newStub(io.grpc.Channel channel) {
    return new documentStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static documentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new documentBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static documentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new documentFutureStub(channel);
  }

  /**
   */
  public static abstract class documentImplBase implements io.grpc.BindableService {

    /**
     */
    public void store(com.mcz.docmanager.grpc.Document.StoreRequest request,
        io.grpc.stub.StreamObserver<com.mcz.docmanager.grpc.Document.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStoreMethod(), responseObserver);
    }

    /**
     */
    public void update(com.mcz.docmanager.grpc.Document.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.mcz.docmanager.grpc.Document.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStoreMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mcz.docmanager.grpc.Document.StoreRequest,
                com.mcz.docmanager.grpc.Document.APIResponse>(
                  this, METHODID_STORE)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mcz.docmanager.grpc.Document.UpdateRequest,
                com.mcz.docmanager.grpc.Document.APIResponse>(
                  this, METHODID_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class documentStub extends io.grpc.stub.AbstractStub<documentStub> {
    private documentStub(io.grpc.Channel channel) {
      super(channel);
    }

    private documentStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected documentStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new documentStub(channel, callOptions);
    }

    /**
     */
    public void store(com.mcz.docmanager.grpc.Document.StoreRequest request,
        io.grpc.stub.StreamObserver<com.mcz.docmanager.grpc.Document.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.mcz.docmanager.grpc.Document.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.mcz.docmanager.grpc.Document.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class documentBlockingStub extends io.grpc.stub.AbstractStub<documentBlockingStub> {
    private documentBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private documentBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected documentBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new documentBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mcz.docmanager.grpc.Document.APIResponse store(com.mcz.docmanager.grpc.Document.StoreRequest request) {
      return blockingUnaryCall(
          getChannel(), getStoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mcz.docmanager.grpc.Document.APIResponse update(com.mcz.docmanager.grpc.Document.UpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class documentFutureStub extends io.grpc.stub.AbstractStub<documentFutureStub> {
    private documentFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private documentFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected documentFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new documentFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mcz.docmanager.grpc.Document.APIResponse> store(
        com.mcz.docmanager.grpc.Document.StoreRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mcz.docmanager.grpc.Document.APIResponse> update(
        com.mcz.docmanager.grpc.Document.UpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STORE = 0;
  private static final int METHODID_UPDATE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final documentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(documentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STORE:
          serviceImpl.store((com.mcz.docmanager.grpc.Document.StoreRequest) request,
              (io.grpc.stub.StreamObserver<com.mcz.docmanager.grpc.Document.APIResponse>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.mcz.docmanager.grpc.Document.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.mcz.docmanager.grpc.Document.APIResponse>) responseObserver);
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

  private static abstract class documentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    documentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mcz.docmanager.grpc.Document.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("document");
    }
  }

  private static final class documentFileDescriptorSupplier
      extends documentBaseDescriptorSupplier {
    documentFileDescriptorSupplier() {}
  }

  private static final class documentMethodDescriptorSupplier
      extends documentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    documentMethodDescriptorSupplier(String methodName) {
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
      synchronized (documentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new documentFileDescriptorSupplier())
              .addMethod(getStoreMethod())
              .addMethod(getUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
