package com.huongdanjava.eda.requestreply;

import java.util.UUID;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class Requester {

  public static void main(String[] args) throws JMSException {
    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
    try (Connection connection = connectionFactory.createConnection("artemis", "artemis")) {
      connection.start();

      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      Destination requestQueue = session.createQueue("eda.request.queue");
      Destination replyQueue = session.createQueue("eda.reply.queue");

      MessageProducer producer = session.createProducer(requestQueue);
      MessageConsumer consumer = session.createConsumer(replyQueue);

      TextMessage requestMessage = session.createTextMessage("Huong Dan Java");
      String correlationId = UUID.randomUUID().toString();
      requestMessage.setJMSReplyTo(replyQueue);
      requestMessage.setJMSCorrelationID(correlationId);

      producer.send(requestMessage);
      System.out.println("Sent request with correlation ID: " + correlationId);

      Message reply = consumer.receive(5000);
      if (reply instanceof TextMessage) {
        System.out.println("Received reply: " + ((TextMessage) reply).getText());
      }

      session.close();
    }
  }

}
