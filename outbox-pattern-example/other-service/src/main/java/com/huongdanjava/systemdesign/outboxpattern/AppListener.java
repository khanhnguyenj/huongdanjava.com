package com.huongdanjava.systemdesign.outboxpattern;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AppListener {

  @KafkaListener(topics = "outboxpattern.public.outbox", groupId = "huongdanjava")
  public void listen(String message) {
    System.out.println("Received message: " + message);
  }

}
