package com.huongdanjava.eda.requestreply;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receiver {

  public static void main(String[] args)
      throws IOException, TimeoutException, InterruptedException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    try (Connection connection = factory.newConnection()) {
      Channel channel = connection.createChannel();

      channel.queueDeclare("eda.request.queue", false, false, false, null);

      DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        String request = new String(delivery.getBody(), "UTF-8");
        System.out.println("Server received request: " + request);

        String response = String.format("Hello, %s!", request);

        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
            .correlationId(delivery.getProperties().getCorrelationId())
            .build();
        System.out.println("Reply Queue: " + delivery.getProperties().getReplyTo());

        channel.basicPublish("", delivery.getProperties().getReplyTo(), props, response.getBytes());
      };

      channel.basicConsume("eda.request.queue", true, deliverCallback, consumerTag -> {
      });

      // Keep the server alive
      System.out.println("Server is listening...");
      Thread.sleep(60000);
    }
  }

}
