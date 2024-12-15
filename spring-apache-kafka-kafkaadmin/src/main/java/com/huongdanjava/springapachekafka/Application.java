package com.huongdanjava.springapachekafka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaAdmin;

public class Application {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfiguration.class);

    KafkaAdmin kafkaAdmin = context.getBean(KafkaAdmin.class);
    System.out.println(kafkaAdmin.describeTopics("huongdanjava", "huongdanjava1"));
  }

}
