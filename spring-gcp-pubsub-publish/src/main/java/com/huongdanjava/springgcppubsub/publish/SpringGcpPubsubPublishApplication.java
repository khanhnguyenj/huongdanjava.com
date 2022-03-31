package com.huongdanjava.springgcppubsub.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.concurrent.ListenableFuture;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;

@SpringBootApplication
public class SpringGcpPubsubPublishApplication implements CommandLineRunner {

  @Autowired
  private PubSubTemplate pubSubTemplate;

  public static void main(String[] args) {
    SpringApplication.run(SpringGcpPubsubPublishApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    String topicId = "huongdanjava";

    String message = "Hello";
    ByteString data = ByteString.copyFromUtf8(message);
    // @formatter:off
    PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
        .setData(data)
        .build();
    // @formatter:on

    ListenableFuture<String> listenableFuture = pubSubTemplate.publish(topicId, pubsubMessage);

    String messageId = listenableFuture.get();
    System.out.println("Published message ID: " + messageId);
  }

}
