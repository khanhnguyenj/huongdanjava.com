package com.huongdanjava.springcloudstream;

import java.util.function.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Consumer1Application {

  public static void main(String[] args) {
    SpringApplication.run(Consumer1Application.class, args);
  }

  @Bean
  public Consumer<Order> processOrder() {
    return order -> {
      System.out.println("Received: " + order);
    };
  }

}
