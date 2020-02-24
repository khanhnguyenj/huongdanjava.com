package com.huongdanjava.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBootUnitTestApplicationTests {

  @Autowired
  private ApplicationContext context;

  @Test
  public void testCalculation() {
    Assertions.assertTrue(context.getBean(Calculation.class) != null);
  }

  @Test
  public void testHello() {
    Assertions.assertTrue(context.getBean(Hello.class) != null);
  }

}
