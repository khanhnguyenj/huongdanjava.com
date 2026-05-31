package com.huongdanjava.springcloudstream;

import java.util.function.Consumer;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudStreamRabbitmqExampleApplication {

  @Autowired
  private StreamBridge streamBridge;

  static void main(String[] args) {
    SpringApplication.run(SpringCloudStreamRabbitmqExampleApplication.class, args);
  }

  @Bean
  CommandLineRunner runner() {
    return args -> {
      streamBridge.send("sendSupplier-out-0", "Hello World");
    };
  }

//  @Bean
//  public Supplier<String> sendSupplier() {
//    return () -> "Hello World";
//  }

  @Bean
  public Consumer<String> receiveConsumer(MessageStore store) {
    return message -> {
      store.setLastMessage(message);
      System.out.println("Received: " + message);
    };
  }

  @Bean
  public Function<String, String> uppercase() {
    return message -> {
      System.out.printf("Received for uppercase: %s%n", message);
      return message.toUpperCase();
    };
  }

}
