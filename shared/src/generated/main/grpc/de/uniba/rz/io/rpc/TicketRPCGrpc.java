package de.uniba.rz.io.rpc;

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
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: ticketManagement.proto")
public final class TicketRPCGrpc {

  private TicketRPCGrpc() {}

  public static final String SERVICE_NAME = "TicketRPC";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketRequest,
      de.uniba.rz.io.rpc.TicketResponse> getCreateTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createTicket",
      requestType = de.uniba.rz.io.rpc.TicketRequest.class,
      responseType = de.uniba.rz.io.rpc.TicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketRequest,
      de.uniba.rz.io.rpc.TicketResponse> getCreateTicketMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketRequest, de.uniba.rz.io.rpc.TicketResponse> getCreateTicketMethod;
    if ((getCreateTicketMethod = TicketRPCGrpc.getCreateTicketMethod) == null) {
      synchronized (TicketRPCGrpc.class) {
        if ((getCreateTicketMethod = TicketRPCGrpc.getCreateTicketMethod) == null) {
          TicketRPCGrpc.getCreateTicketMethod = getCreateTicketMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketRequest, de.uniba.rz.io.rpc.TicketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TicketRPC", "createTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketRPCMethodDescriptorSupplier("createTicket"))
                  .build();
          }
        }
     }
     return getCreateTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.Empty,
      de.uniba.rz.io.rpc.TicketList> getGetAllTicketsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllTickets",
      requestType = de.uniba.rz.io.rpc.Empty.class,
      responseType = de.uniba.rz.io.rpc.TicketList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.Empty,
      de.uniba.rz.io.rpc.TicketList> getGetAllTicketsMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.Empty, de.uniba.rz.io.rpc.TicketList> getGetAllTicketsMethod;
    if ((getGetAllTicketsMethod = TicketRPCGrpc.getGetAllTicketsMethod) == null) {
      synchronized (TicketRPCGrpc.class) {
        if ((getGetAllTicketsMethod = TicketRPCGrpc.getGetAllTicketsMethod) == null) {
          TicketRPCGrpc.getGetAllTicketsMethod = getGetAllTicketsMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.Empty, de.uniba.rz.io.rpc.TicketList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TicketRPC", "getAllTickets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketList.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketRPCMethodDescriptorSupplier("getAllTickets"))
                  .build();
          }
        }
     }
     return getGetAllTicketsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId,
      de.uniba.rz.io.rpc.TicketResponse> getGetTicketByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTicketById",
      requestType = de.uniba.rz.io.rpc.TicketId.class,
      responseType = de.uniba.rz.io.rpc.TicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId,
      de.uniba.rz.io.rpc.TicketResponse> getGetTicketByIdMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId, de.uniba.rz.io.rpc.TicketResponse> getGetTicketByIdMethod;
    if ((getGetTicketByIdMethod = TicketRPCGrpc.getGetTicketByIdMethod) == null) {
      synchronized (TicketRPCGrpc.class) {
        if ((getGetTicketByIdMethod = TicketRPCGrpc.getGetTicketByIdMethod) == null) {
          TicketRPCGrpc.getGetTicketByIdMethod = getGetTicketByIdMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketId, de.uniba.rz.io.rpc.TicketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TicketRPC", "getTicketById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketRPCMethodDescriptorSupplier("getTicketById"))
                  .build();
          }
        }
     }
     return getGetTicketByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId,
      de.uniba.rz.io.rpc.TicketResponse> getAcceptTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "acceptTicket",
      requestType = de.uniba.rz.io.rpc.TicketId.class,
      responseType = de.uniba.rz.io.rpc.TicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId,
      de.uniba.rz.io.rpc.TicketResponse> getAcceptTicketMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId, de.uniba.rz.io.rpc.TicketResponse> getAcceptTicketMethod;
    if ((getAcceptTicketMethod = TicketRPCGrpc.getAcceptTicketMethod) == null) {
      synchronized (TicketRPCGrpc.class) {
        if ((getAcceptTicketMethod = TicketRPCGrpc.getAcceptTicketMethod) == null) {
          TicketRPCGrpc.getAcceptTicketMethod = getAcceptTicketMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketId, de.uniba.rz.io.rpc.TicketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TicketRPC", "acceptTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketRPCMethodDescriptorSupplier("acceptTicket"))
                  .build();
          }
        }
     }
     return getAcceptTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId,
      de.uniba.rz.io.rpc.TicketResponse> getRejectTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "rejectTicket",
      requestType = de.uniba.rz.io.rpc.TicketId.class,
      responseType = de.uniba.rz.io.rpc.TicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId,
      de.uniba.rz.io.rpc.TicketResponse> getRejectTicketMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId, de.uniba.rz.io.rpc.TicketResponse> getRejectTicketMethod;
    if ((getRejectTicketMethod = TicketRPCGrpc.getRejectTicketMethod) == null) {
      synchronized (TicketRPCGrpc.class) {
        if ((getRejectTicketMethod = TicketRPCGrpc.getRejectTicketMethod) == null) {
          TicketRPCGrpc.getRejectTicketMethod = getRejectTicketMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketId, de.uniba.rz.io.rpc.TicketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TicketRPC", "rejectTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketRPCMethodDescriptorSupplier("rejectTicket"))
                  .build();
          }
        }
     }
     return getRejectTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId,
      de.uniba.rz.io.rpc.TicketResponse> getCloseTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "closeTicket",
      requestType = de.uniba.rz.io.rpc.TicketId.class,
      responseType = de.uniba.rz.io.rpc.TicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId,
      de.uniba.rz.io.rpc.TicketResponse> getCloseTicketMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.TicketId, de.uniba.rz.io.rpc.TicketResponse> getCloseTicketMethod;
    if ((getCloseTicketMethod = TicketRPCGrpc.getCloseTicketMethod) == null) {
      synchronized (TicketRPCGrpc.class) {
        if ((getCloseTicketMethod = TicketRPCGrpc.getCloseTicketMethod) == null) {
          TicketRPCGrpc.getCloseTicketMethod = getCloseTicketMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.TicketId, de.uniba.rz.io.rpc.TicketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TicketRPC", "closeTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketRPCMethodDescriptorSupplier("closeTicket"))
                  .build();
          }
        }
     }
     return getCloseTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.AutoNewTicketRequest,
      de.uniba.rz.io.rpc.TicketList> getStreamNewTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamNewTicket",
      requestType = de.uniba.rz.io.rpc.AutoNewTicketRequest.class,
      responseType = de.uniba.rz.io.rpc.TicketList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.AutoNewTicketRequest,
      de.uniba.rz.io.rpc.TicketList> getStreamNewTicketMethod() {
    io.grpc.MethodDescriptor<de.uniba.rz.io.rpc.AutoNewTicketRequest, de.uniba.rz.io.rpc.TicketList> getStreamNewTicketMethod;
    if ((getStreamNewTicketMethod = TicketRPCGrpc.getStreamNewTicketMethod) == null) {
      synchronized (TicketRPCGrpc.class) {
        if ((getStreamNewTicketMethod = TicketRPCGrpc.getStreamNewTicketMethod) == null) {
          TicketRPCGrpc.getStreamNewTicketMethod = getStreamNewTicketMethod = 
              io.grpc.MethodDescriptor.<de.uniba.rz.io.rpc.AutoNewTicketRequest, de.uniba.rz.io.rpc.TicketList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "TicketRPC", "StreamNewTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.AutoNewTicketRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.uniba.rz.io.rpc.TicketList.getDefaultInstance()))
                  .setSchemaDescriptor(new TicketRPCMethodDescriptorSupplier("StreamNewTicket"))
                  .build();
          }
        }
     }
     return getStreamNewTicketMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TicketRPCStub newStub(io.grpc.Channel channel) {
    return new TicketRPCStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TicketRPCBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TicketRPCBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TicketRPCFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TicketRPCFutureStub(channel);
  }

  /**
   */
  public static abstract class TicketRPCImplBase implements io.grpc.BindableService {

    /**
     */
    public void createTicket(de.uniba.rz.io.rpc.TicketRequest request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTicketMethod(), responseObserver);
    }

    /**
     */
    public void getAllTickets(de.uniba.rz.io.rpc.Empty request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllTicketsMethod(), responseObserver);
    }

    /**
     */
    public void getTicketById(de.uniba.rz.io.rpc.TicketId request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTicketByIdMethod(), responseObserver);
    }

    /**
     */
    public void acceptTicket(de.uniba.rz.io.rpc.TicketId request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAcceptTicketMethod(), responseObserver);
    }

    /**
     */
    public void rejectTicket(de.uniba.rz.io.rpc.TicketId request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRejectTicketMethod(), responseObserver);
    }

    /**
     */
    public void closeTicket(de.uniba.rz.io.rpc.TicketId request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCloseTicketMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.AutoNewTicketRequest> streamNewTicket(
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketList> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamNewTicketMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketRequest,
                de.uniba.rz.io.rpc.TicketResponse>(
                  this, METHODID_CREATE_TICKET)))
          .addMethod(
            getGetAllTicketsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.Empty,
                de.uniba.rz.io.rpc.TicketList>(
                  this, METHODID_GET_ALL_TICKETS)))
          .addMethod(
            getGetTicketByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketId,
                de.uniba.rz.io.rpc.TicketResponse>(
                  this, METHODID_GET_TICKET_BY_ID)))
          .addMethod(
            getAcceptTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketId,
                de.uniba.rz.io.rpc.TicketResponse>(
                  this, METHODID_ACCEPT_TICKET)))
          .addMethod(
            getRejectTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketId,
                de.uniba.rz.io.rpc.TicketResponse>(
                  this, METHODID_REJECT_TICKET)))
          .addMethod(
            getCloseTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.TicketId,
                de.uniba.rz.io.rpc.TicketResponse>(
                  this, METHODID_CLOSE_TICKET)))
          .addMethod(
            getStreamNewTicketMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                de.uniba.rz.io.rpc.AutoNewTicketRequest,
                de.uniba.rz.io.rpc.TicketList>(
                  this, METHODID_STREAM_NEW_TICKET)))
          .build();
    }
  }

  /**
   */
  public static final class TicketRPCStub extends io.grpc.stub.AbstractStub<TicketRPCStub> {
    private TicketRPCStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketRPCStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketRPCStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketRPCStub(channel, callOptions);
    }

    /**
     */
    public void createTicket(de.uniba.rz.io.rpc.TicketRequest request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllTickets(de.uniba.rz.io.rpc.Empty request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllTicketsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTicketById(de.uniba.rz.io.rpc.TicketId request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTicketByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acceptTicket(de.uniba.rz.io.rpc.TicketId request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAcceptTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rejectTicket(de.uniba.rz.io.rpc.TicketId request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRejectTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeTicket(de.uniba.rz.io.rpc.TicketId request,
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCloseTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.AutoNewTicketRequest> streamNewTicket(
        io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketList> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamNewTicketMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TicketRPCBlockingStub extends io.grpc.stub.AbstractStub<TicketRPCBlockingStub> {
    private TicketRPCBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketRPCBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketRPCBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketRPCBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketResponse createTicket(de.uniba.rz.io.rpc.TicketRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketList getAllTickets(de.uniba.rz.io.rpc.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllTicketsMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketResponse getTicketById(de.uniba.rz.io.rpc.TicketId request) {
      return blockingUnaryCall(
          getChannel(), getGetTicketByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketResponse acceptTicket(de.uniba.rz.io.rpc.TicketId request) {
      return blockingUnaryCall(
          getChannel(), getAcceptTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketResponse rejectTicket(de.uniba.rz.io.rpc.TicketId request) {
      return blockingUnaryCall(
          getChannel(), getRejectTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.uniba.rz.io.rpc.TicketResponse closeTicket(de.uniba.rz.io.rpc.TicketId request) {
      return blockingUnaryCall(
          getChannel(), getCloseTicketMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TicketRPCFutureStub extends io.grpc.stub.AbstractStub<TicketRPCFutureStub> {
    private TicketRPCFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TicketRPCFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketRPCFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TicketRPCFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketResponse> createTicket(
        de.uniba.rz.io.rpc.TicketRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketList> getAllTickets(
        de.uniba.rz.io.rpc.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllTicketsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketResponse> getTicketById(
        de.uniba.rz.io.rpc.TicketId request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTicketByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketResponse> acceptTicket(
        de.uniba.rz.io.rpc.TicketId request) {
      return futureUnaryCall(
          getChannel().newCall(getAcceptTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketResponse> rejectTicket(
        de.uniba.rz.io.rpc.TicketId request) {
      return futureUnaryCall(
          getChannel().newCall(getRejectTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.uniba.rz.io.rpc.TicketResponse> closeTicket(
        de.uniba.rz.io.rpc.TicketId request) {
      return futureUnaryCall(
          getChannel().newCall(getCloseTicketMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TICKET = 0;
  private static final int METHODID_GET_ALL_TICKETS = 1;
  private static final int METHODID_GET_TICKET_BY_ID = 2;
  private static final int METHODID_ACCEPT_TICKET = 3;
  private static final int METHODID_REJECT_TICKET = 4;
  private static final int METHODID_CLOSE_TICKET = 5;
  private static final int METHODID_STREAM_NEW_TICKET = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TicketRPCImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TicketRPCImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TICKET:
          serviceImpl.createTicket((de.uniba.rz.io.rpc.TicketRequest) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_TICKETS:
          serviceImpl.getAllTickets((de.uniba.rz.io.rpc.Empty) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketList>) responseObserver);
          break;
        case METHODID_GET_TICKET_BY_ID:
          serviceImpl.getTicketById((de.uniba.rz.io.rpc.TicketId) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse>) responseObserver);
          break;
        case METHODID_ACCEPT_TICKET:
          serviceImpl.acceptTicket((de.uniba.rz.io.rpc.TicketId) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse>) responseObserver);
          break;
        case METHODID_REJECT_TICKET:
          serviceImpl.rejectTicket((de.uniba.rz.io.rpc.TicketId) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse>) responseObserver);
          break;
        case METHODID_CLOSE_TICKET:
          serviceImpl.closeTicket((de.uniba.rz.io.rpc.TicketId) request,
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketResponse>) responseObserver);
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
        case METHODID_STREAM_NEW_TICKET:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamNewTicket(
              (io.grpc.stub.StreamObserver<de.uniba.rz.io.rpc.TicketList>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TicketRPCBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TicketRPCBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.uniba.rz.io.rpc.TicketManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TicketRPC");
    }
  }

  private static final class TicketRPCFileDescriptorSupplier
      extends TicketRPCBaseDescriptorSupplier {
    TicketRPCFileDescriptorSupplier() {}
  }

  private static final class TicketRPCMethodDescriptorSupplier
      extends TicketRPCBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TicketRPCMethodDescriptorSupplier(String methodName) {
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
      synchronized (TicketRPCGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TicketRPCFileDescriptorSupplier())
              .addMethod(getCreateTicketMethod())
              .addMethod(getGetAllTicketsMethod())
              .addMethod(getGetTicketByIdMethod())
              .addMethod(getAcceptTicketMethod())
              .addMethod(getRejectTicketMethod())
              .addMethod(getCloseTicketMethod())
              .addMethod(getStreamNewTicketMethod())
              .build();
        }
      }
    }
    return result;
  }
}
