package com.huongdanjava.systemdesign.sagapattern.orderservice;

import java.time.Duration;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.StreamJoined;
import org.apache.kafka.streams.kstream.ValueJoiner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JacksonJsonSerde;

@Configuration
public class OrderStreamTopology {

  @Bean
  public KStream<Long, Order> orderStream(StreamsBuilder builder) {
    KStream<Long, Order> paymentOrders = builder.stream("payment-orders");
    KStream<Long, Order> stockOrders = builder.stream("stock-orders");

    JacksonJsonSerde<Order> orderSerde = new JacksonJsonSerde<>(Order.class);

    paymentOrders
        .join(
            stockOrders,
            (ValueJoiner<Order, Order, Order>) (value1, value2) -> null,
            JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMillis(10)),
            StreamJoined.with(Serdes.Long(), orderSerde, orderSerde))
        .to("orders");

    return paymentOrders;
  }
}
