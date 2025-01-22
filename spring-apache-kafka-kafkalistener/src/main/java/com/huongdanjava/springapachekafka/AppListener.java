package com.huongdanjava.springapachekafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AppListener {

  @KafkaListener(topics = "huongdanjava", groupId = "huongdanjava")
  public void listen(String message) {
    System.out.println(message);
  }

}
