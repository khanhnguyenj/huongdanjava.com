package com.huongdanjava.eda.requestreply;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class Receiver {

  public static void main(String[] args) throws JMSException, InterruptedException {
    ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
    try (Connection connection = factory.createConnection("artemis", "artemis")) {
      connection.start();

      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      Destination requestQueue = session.createQueue("eda.request.queue");

      MessageConsumer consumer = session.createConsumer(requestQueue);

      consumer.setMessageListener(message -> {
        try {
          if (message instanceof TextMessage) {
            String requestText = ((TextMessage) message).getText();
            System.out.println("Server received request: " + requestText);

            Destination replyTo = message.getJMSReplyTo();
            if (replyTo != null) {
              MessageProducer replyProducer = session.createProducer(replyTo);
              TextMessage replyMessage = session.createTextMessage("Hello, " + requestText);
              replyMessage.setJMSCorrelationID(message.getJMSCorrelationID());

              replyProducer.send(replyMessage);
              replyProducer.close();
            }
          }
        } catch (JMSException e) {
          e.printStackTrace();
        }
      });

      // Keep the server alive
      System.out.println("Server is listening...");
      Thread.sleep(60000);
    }
  }
}
