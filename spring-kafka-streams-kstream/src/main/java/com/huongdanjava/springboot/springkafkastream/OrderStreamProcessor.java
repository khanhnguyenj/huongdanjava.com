package com.huongdanjava.springboot.springkafkastream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JacksonJsonSerde;

@Configuration
public class OrderStreamProcessor {

  @Bean
  public KStream<String, Order> processOrders(StreamsBuilder builder, JacksonJsonSerde<Order> orderSerde) {

    KStream<String, Order> orders =
        builder.stream("orders", Consumed.with(Serdes.String(), orderSerde));

    KStream<String, Order> highValueOrders = orders.filter((key, order) -> order.amount() > 1000);

    highValueOrders
        .mapValues(order -> new Order(order.id(), order.customerId(), order.amount(), "HIGH_VALUE"))
        .peek((key, value) -> System.out.println("Processing order: " + value))
        .to("high-value-orders", Produced.with(Serdes.String(), orderSerde));

    return orders;
  }
}
