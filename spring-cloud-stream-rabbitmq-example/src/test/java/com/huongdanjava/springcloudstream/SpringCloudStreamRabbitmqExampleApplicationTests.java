package com.huongdanjava.springcloudstream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.EnableTestBinder;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootTest
@EnableTestBinder
class SpringCloudStreamRabbitmqExampleApplicationTests {

  @Autowired
  private InputDestination inputDestination;

  @Autowired
  private OutputDestination outputDestination;

  @Autowired
  private MessageStore store;

  @Test
  void testInputDestination() {
    String testMessage = "Test Message";
    var message = MessageBuilder.withPayload(testMessage)
        .build();

    inputDestination.send(message, "message.exchange");

    assertEquals(testMessage, store.getLastMessage());
  }

  @Test
  void testOutputDestination() {
//    String testMessage = "Test Message";
//    var message = MessageBuilder.withPayload(testMessage)
//        .build();
//
//    inputDestination.send(message, "input.exchange");

    var response = outputDestination.receive(100, "message.exchange");
    assertNotNull(response);
    assertTrue(response.getPayload().length > 0);

    assertEquals("Hello World", new String(response.getPayload()));
  }

}
