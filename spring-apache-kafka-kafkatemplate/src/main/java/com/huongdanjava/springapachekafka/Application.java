package com.huongdanjava.springapachekafka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

public class Application {

  public static void main(String[] args) throws InterruptedException {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfiguration.class);

    KafkaTemplate<String, String> kafkaTemplate = context.getBean(KafkaTemplate.class);

    kafkaTemplate.send("huongdanjava", "Hello World!").thenAccept(System.out::println);

    Thread.sleep(10000);
  }

}
