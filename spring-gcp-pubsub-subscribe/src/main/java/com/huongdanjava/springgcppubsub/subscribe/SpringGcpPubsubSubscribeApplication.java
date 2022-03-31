package com.huongdanjava.springgcppubsub.subscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.pubsub.v1.PubsubMessage;

@SpringBootApplication
public class SpringGcpPubsubSubscribeApplication implements CommandLineRunner {

  @Autowired
  private PubSubTemplate pubSubTemplate;

  public static void main(String[] args) {
    SpringApplication.run(SpringGcpPubsubSubscribeApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    String subscription = "projects/crested-trainer-341707/subscriptions/huongdanjava-sub";

    pubSubTemplate.subscribe(subscription, c -> {
      PubsubMessage pubsubMessage = c.getPubsubMessage();

      System.out.println(pubsubMessage.getData().toStringUtf8());
    });

    Thread.sleep(100000L);
  }

}
