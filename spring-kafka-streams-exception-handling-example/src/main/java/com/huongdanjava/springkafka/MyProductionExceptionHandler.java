package com.huongdanjava.springkafka;

import java.util.Map;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.errors.ErrorHandlerContext;
import org.apache.kafka.streams.errors.ProductionExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyProductionExceptionHandler implements ProductionExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(MyProductionExceptionHandler.class);

  @Override
  public Response handleError(
      ErrorHandlerContext context, ProducerRecord<byte[], byte[]> record, Exception exception) {
    logger.error(
        "Failed to produce record. topic={}, partition={}, key={}, value={}",
        record.topic(),
        record.partition(),
        record.key(),
        record.value(),
        exception);

    return Response.resume();
  }

  @Override
  public void configure(Map<String, ?> configs) {}
}
