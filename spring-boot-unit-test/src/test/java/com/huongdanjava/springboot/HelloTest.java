package com.huongdanjava.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class HelloTest {

  @Autowired
  private ApplicationContext context;

  @Test
  public void testSay() {
    Hello hello = context.getBean(Hello.class);

    Assertions.assertEquals("Hello Khanh", hello.say("Khanh"));
  }
}
