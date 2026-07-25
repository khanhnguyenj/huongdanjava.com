package com.huongdanjava.springkafka;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JacksonJsonSerde;

@Configuration
public class UserStreamTopology {

  private static final Logger logger = LoggerFactory.getLogger(UserStreamTopology.class);

  //  @Bean
  //  public KStream<String, User> users(StreamsBuilder builder) {
  //    KStream<String, User> stream =
  //        builder.stream("users", Consumed.with(Serdes.String(), new
  // JacksonJsonSerde<>(User.class)));
  //
  //    stream.peek((k, v) -> logger.info(v.toString()));
  //
  //    return stream;
  //  }

  //  @Bean
  //  public KStream<String, String> users(StreamsBuilder builder) {
  //    KStream<String, String> stream = builder.stream("users");
  //
  //    stream
  //        .mapValues(
  //            value -> {
  //              logger.info("Received: {}", value);
  //
  //              if (value.equals("ERROR")) {
  //                throw new RuntimeException("Something went wrong!");
  //              }
  //
  //              return value.toUpperCase();
  //            })
  //        .to("output");
  //
  //    return stream;
  //  }

  @Bean
  public KStream<String, User> users(StreamsBuilder builder) {
    KStream<String, User> stream = builder.stream("users");

    stream.to("output", Produced.with(Serdes.String(), new JacksonJsonSerde<>(User.class)));

    return stream;
  }
}
