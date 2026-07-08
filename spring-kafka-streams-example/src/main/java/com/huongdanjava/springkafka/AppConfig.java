package com.huongdanjava.springkafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.DefaultProductionExceptionHandler;
import org.apache.kafka.streams.errors.LogAndContinueExceptionHandler;
import org.apache.kafka.streams.errors.LogAndContinueProcessingExceptionHandler;
import org.apache.kafka.streams.errors.StreamsUncaughtExceptionHandler;
import org.apache.kafka.streams.errors.StreamsUncaughtExceptionHandler.StreamThreadExceptionResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.KafkaStreamsCustomizer;
import org.springframework.kafka.config.StreamsBuilderFactoryBeanConfigurer;

@Configuration
@EnableKafkaStreams
public class AppConfig {

  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
  public KafkaStreamsConfiguration kafkaStreamsConfiguration() {
    Map<String, Object> props = new HashMap();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "spring-kafka-streams-example");
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
    props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//    props.put(
//        StreamsConfig.PROCESSING_EXCEPTION_HANDLER_CLASS_CONFIG,
//        LogAndContinueProcessingExceptionHandler.class.getName());
//    props.put(
//        StreamsConfig.PRODUCTION_EXCEPTION_HANDLER_CLASS_CONFIG,
//        DefaultProductionExceptionHandler.class.getName());
//    props.put(
//        StreamsConfig.DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG,
//        LogAndContinueExceptionHandler.class.getName());

    return new KafkaStreamsConfiguration(props);
  }

  @Bean
  public StreamsBuilderFactoryBeanConfigurer streamsCustomizer() {
    return factoryBean ->
        factoryBean.setStreamsUncaughtExceptionHandler(
            exception -> {
              exception.printStackTrace();

              return StreamsUncaughtExceptionHandler.StreamThreadExceptionResponse.REPLACE_THREAD;
            });
  }

//  @Bean
//  KafkaStreamsCustomizer kafkaStreamsCustomizer() {
//    return kafkaStreams ->
//        kafkaStreams.setUncaughtExceptionHandler(
//            exception -> {
//              exception.printStackTrace();
//
//              return StreamThreadExceptionResponse.SHUTDOWN_CLIENT;
//            });
//  }
}
