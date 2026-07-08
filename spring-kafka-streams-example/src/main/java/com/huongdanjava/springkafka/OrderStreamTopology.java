package com.huongdanjava.springkafka;

import java.time.Duration;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.StreamJoined;
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

  //  @Bean
  //  public KStream<String, String> orders(StreamsBuilder builder) {
  //    KTable<String, String> customers = builder.table("customers");
  //
  //    KStream<String, String> orders = builder.stream("orders");
  //
  //    orders
  //        .join(
  //            customers,
  //            (ValueJoiner<String, String, Object>)
  //                (orderName, customerName) -> {
  //                  System.out.println(
  //                      "Joining order: " + orderName + " with customer: " + customerName);
  //                  return String.format("%s ordered %s", customerName, orderName);
  //                },
  //            Joined.with(Serdes.String(), Serdes.String(), Serdes.String()))
  //        .to("enriched-orders");
  //
  //    return orders;
  //  }

  @Bean
  public KStream<String, String> orderStream(StreamsBuilder builder) {
    try {
      KStream<String, String> customers = builder.stream("customers");
      KStream<String, String> orders = builder.stream("orders");

      customers
          .join(
              orders,
              (ValueJoiner<String, String, String>)
                  (customer, order) -> String.format("Customer %s ordered %s", customer, order),
              JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofMinutes(100)),
              StreamJoined.with(Serdes.String(), Serdes.String(), Serdes.String()))
          .to("enriched-orders");

      return customers;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
