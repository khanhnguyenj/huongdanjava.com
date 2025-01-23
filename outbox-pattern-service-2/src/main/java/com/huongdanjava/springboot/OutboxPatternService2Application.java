package com.huongdanjava.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class OutboxPatternService2Application {

  public static void main(String[] args) {
    SpringApplication.run(OutboxPatternService2Application.class, args);
  }

}
