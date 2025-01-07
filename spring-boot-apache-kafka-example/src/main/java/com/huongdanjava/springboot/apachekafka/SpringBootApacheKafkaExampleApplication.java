package com.huongdanjava.springboot.apachekafka;

import java.util.concurrent.CompletableFuture;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

@SpringBootApplication
public class SpringBootApacheKafkaExampleApplication {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootApacheKafkaExampleApplication.class, args);
  }

  @Bean
  public NewTopic topic1() {
    return new NewTopic("huongdanjava", 1, (short) 1);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("huongdanjava",
          "Hello World!");
      future.thenAccept(result -> {
        System.out.println(result);
      });

      Thread.sleep(10000);
    };
  }

}