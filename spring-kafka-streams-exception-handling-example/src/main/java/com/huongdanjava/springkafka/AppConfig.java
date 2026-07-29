package com.huongdanjava.springkafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBeanConfigurer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.streams.KafkaStreamsDeadLetterDestinationResolver;
import org.springframework.kafka.streams.RecoveringDeserializationExceptionHandler;
import org.springframework.kafka.streams.RecoveringProcessingExceptionHandler;
import org.springframework.kafka.streams.RecoveringProductionExceptionHandler;

@Configuration
@EnableKafkaStreams
public class AppConfig {

  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
  public KafkaStreamsConfiguration kafkaStreamsConfiguration(
      KafkaStreamsDeadLetterDestinationResolver resolver, DeadLetterPublishingRecoverer recoverer) {
    Map<String, Object> props = new HashMap();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "spring-kafka-streams-example");
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
    props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
    //    props.put(StreamsConfig.ERRORS_DEAD_LETTER_QUEUE_TOPIC_NAME_CONFIG, "default-dlq-topic");
    props.put(
        StreamsConfig.DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG,
        RecoveringDeserializationExceptionHandler.class.getName());
    props.put(
        StreamsConfig.PROCESSING_EXCEPTION_HANDLER_CLASS_CONFIG,
        RecoveringProcessingExceptionHandler.class.getName());
    props.put(
        StreamsConfig.PRODUCTION_EXCEPTION_HANDLER_CLASS_CONFIG,
        RecoveringProductionExceptionHandler.class.getName());

    props.put(RecoveringDeserializationExceptionHandler.DLQ_DESTINATION_RESOLVER, resolver);
    props.put(RecoveringProcessingExceptionHandler.DLQ_DESTINATION_RESOLVER, resolver);
    props.put(RecoveringProductionExceptionHandler.DLQ_DESTINATION_RESOLVER, resolver);

    props.put(RecoveringDeserializationExceptionHandler.RECOVERER, recoverer);
    props.put(RecoveringProcessingExceptionHandler.RECOVERER, recoverer);
    props.put(RecoveringProductionExceptionHandler.RECOVERER, recoverer);

    return new KafkaStreamsConfiguration(props);
  }

  @Bean
  public StreamsBuilderFactoryBeanConfigurer streamsBuilderFactoryBeanConfigurer() {
    return sfb -> sfb.setDeadLetterTopicName("default2-dlq-topic");
  }

  @Bean
  public DeadLetterPublishingRecoverer recoverer(KafkaTemplate kafkaTemplate) {
    return new DeadLetterPublishingRecoverer(
        kafkaTemplate, (record, ex) -> new TopicPartition("default3-dlq-topic", 0));
  }

  @Bean
  KafkaTemplate<byte[], byte[]> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

  @Bean
  public ProducerFactory<byte[], byte[]> producerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

    return new DefaultKafkaProducerFactory<>(props);
  }

  @Bean
  public KafkaStreamsDeadLetterDestinationResolver resolver() {
    return (context, message, exception) -> {
      if (context.processorNodeId().equals("huongdanjava")) {
        return new TopicPartition("huongdanjava-dlq-topic", -1);
      }

      if (message.value() instanceof String m && m.equals("ERROR")) {
        return new TopicPartition("error-message-dlq-topic", -1);
      }

      if (exception instanceof NumberFormatException) {
        return new TopicPartition("invalid-dlq-topic", -1);
      }

      return new TopicPartition("default1-dlq-topic", 0);
    };
  }

  //  @Bean
  //  public StreamsBuilderFactoryBeanConfigurer streamsCustomizer() {
  //    return factoryBean ->
  //        factoryBean.setStreamsUncaughtExceptionHandler(
  //            _ -> StreamThreadExceptionResponse.REPLACE_THREAD);
  //  }
}
