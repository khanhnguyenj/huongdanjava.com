package com.huongdanjava.springkafka;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Joined;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.ValueJoiner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderStreamTopology {

  //  @Bean
  //  public KStream<String, String> orderStream(StreamsBuilder builder) {
  //    KStream<String, String> orders = builder.stream("orders");
  //
  //    KStream<String, String> createdOrders =
  //        orders
  //            .filter((key, value) -> "CREATED".equals(value))
  //            .mapValues(value -> "PROCESSED_" + value);
  //
  //    createdOrders.to("created-orders");
  //
  //    return orders;
  //  }

  //  @Bean
  //  public KTable<Object, Long> orders(StreamsBuilder builder) {
  //    KTable<Object, Long> orders = builder.stream("customers").groupByKey().count();
  //
  //    orders.toStream().foreach((key, value) -> System.out.println(key + " : " + value));
  //
  //    return orders;
  //  }

  @Bean
  public KStream<String, String> orders(StreamsBuilder builder) {
    KTable<String, String> customers = builder.table("customers");

    KStream<String, String> orders = builder.stream("orders");

    orders
        .join(
            customers,
            (ValueJoiner<String, String, Object>)
                (orderName, customerName) -> {
                  System.out.println(
                      "Joining order: " + orderName + " with customer: " + customerName);
                  return String.format("%s ordered %s", customerName, orderName);
                },
            Joined.with(Serdes.String(), Serdes.String(), Serdes.String()))
        .to("enriched-orders");

    return orders;
  }
}
