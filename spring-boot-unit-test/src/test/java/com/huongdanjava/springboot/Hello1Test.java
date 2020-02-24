package com.huongdanjava.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = { TestConfiguration.class })
public class Hello1Test {

  @Autowired
  private ApplicationContext context;

  @Test
  public void testSay() {
    Hello hello = context.getBean(Hello.class);

    Assertions.assertEquals("Hello Khanh", hello.say("Khanh"));
  }

  @Test
  public void testBeanConfiguration() {
    Calculation calculation = context.getBean(Calculation.class);

  }
}
