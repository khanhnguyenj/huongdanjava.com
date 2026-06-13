package com.huongdanjava.systemdesign.outboxpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class OutboxPatternOtherServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(OutboxPatternOtherServiceApplication.class, args);
  }

}
