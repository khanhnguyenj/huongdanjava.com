package com.huongdanjava.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Application {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    HelloServiceGrpc.HelloServiceBlockingStub stub
        = HelloServiceGrpc.newBlockingStub(channel);

    HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
        .setName("Khanh")
        .build());

    System.out.println(helloResponse.getMessage());

    channel.shutdown();
  }
}
