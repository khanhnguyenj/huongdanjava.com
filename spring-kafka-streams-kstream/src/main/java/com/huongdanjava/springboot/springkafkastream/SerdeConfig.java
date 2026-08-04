package com.huongdanjava.springboot.springkafkastream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JacksonJsonSerde;

@Configuration
public class SerdeConfig {

  @Bean
  public JacksonJsonSerde<Order> orderSerde() {
    return new JacksonJsonSerde<>(Order.class);
  }
}
