package com.huongdanjava.grpc;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

  @Override
  public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    String greeting = "Hello " + request.getName() + " from Huong Dan Java";

    HelloResponse response = HelloResponse.newBuilder()
        .setMessage(greeting)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
