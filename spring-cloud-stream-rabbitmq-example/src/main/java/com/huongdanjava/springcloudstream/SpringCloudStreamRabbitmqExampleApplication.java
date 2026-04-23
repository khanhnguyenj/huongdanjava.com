package com.huongdanjava.springcloudstream;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudStreamRabbitmqExampleApplication {

  static void main(String[] args) {
    SpringApplication.run(SpringCloudStreamRabbitmqExampleApplication.class, args);
  }

  @Bean
  public Supplier<String> sendSupplier() {
    return () -> "Hello World";
  }

  @Bean
  public Consumer<String> receiveConsumer() {
    return message -> {
      System.out.println("Received: " + message);
    };
  }

}
