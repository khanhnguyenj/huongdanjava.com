package com.huongdanjava.springkafka;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderStreamTopology {

  @Bean
  public KStream<String, String> orderStream(StreamsBuilder builder) {
    KStream<String, String> orders = builder.stream("orders");

    KStream<String, String> createdOrders =
        orders
            .filter((key, value) -> "CREATED".equals(value))
            .mapValues(value -> "PROCESSED_" + value);

    createdOrders.to("created-orders");

    return orders;
  }
}
