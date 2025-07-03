package com.huongdanjava.eda.requestreply;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class Requester {

  public static void main(String[] args)
      throws IOException, TimeoutException, InterruptedException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    try (Connection connection = factory.newConnection()) {
      Channel channel = connection.createChannel();

      String replyQueue = channel.queueDeclare("", false, true, true, null).getQueue();

      String correlationId = UUID.randomUUID().toString();

      AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
          .correlationId(correlationId)
          .replyTo(replyQueue)
          .build();

      String message = "Huong Dan Java";
      channel.basicPublish("", "eda.request.queue", props, message.getBytes());
      System.out.println("Sent request with correlation ID: " + correlationId);

      DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        if (delivery.getProperties().getCorrelationId().equals(correlationId)) {
          String response = new String(delivery.getBody(), "UTF-8");

          System.out.println("Received reply: " + response);
        }
      };

      channel.basicConsume(replyQueue, true, deliverCallback, consumerTag -> {
      });

      Thread.sleep(5000);
    }
  }

}
