package com.huongdanjava.systemdesign.sagapattern.paymentservice;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
public class AppConfig {

  @KafkaListener(topics = "orders", groupId = "payment-service")
  public void receiveOrders(Order order) {

  }
}
