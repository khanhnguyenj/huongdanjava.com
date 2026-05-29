package com.huongdanjava.springcloudstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

  @Autowired
  private StreamBridge streamBridge;

  public static void main(String[] args) {
    SpringApplication.run(ProducerApplication.class, args);
  }

  @Bean
  CommandLineRunner runner() {
    return args -> {
      streamBridge.send("sendMessage", new Order(100L, "Laptop"));
      streamBridge.send("sendMessage", new Order(101L, "Phone"));
      streamBridge.send("sendMessage", new Order(102L, "Keyboard"));
      streamBridge.send("sendMessage", new Order(100L, "Mouse"));
    };
  }
}
