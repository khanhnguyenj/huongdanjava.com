package com.huongdanjava.springcloudstream;

import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
public class SpringCloudStreamRoutingExampleApplication {

  @Autowired
  private StreamBridge streamBridge;

  static void main(String[] args) {
    SpringApplication.run(SpringCloudStreamRoutingExampleApplication.class, args);
  }

  @Bean
  CommandLineRunner runner() {
    return args -> {
      Message message = MessageBuilder
          .withPayload("Hello World")
          .setHeader("eventType", "receiveMessage1")
          .build();

      streamBridge.send("sendMessage", message);
    };
  }

  @Bean
  public Consumer<String> receiveMessage1() {
    return message -> System.out.println("Received from consumer 1 : " + message);
  }

  @Bean
  public Consumer<String> receiveMessage2() {
    return message -> System.out.println("Received from consumer 2 : " + message);
  }
}
