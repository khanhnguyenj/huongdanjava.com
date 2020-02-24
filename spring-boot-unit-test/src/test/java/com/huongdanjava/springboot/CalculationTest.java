package com.huongdanjava.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class CalculationTest {

  @Autowired
  private ApplicationContext context;

  @Test
  public void testSum() {
    Calculation calculation = context.getBean(Calculation.class);

    Assertions.assertEquals(9, calculation.sum(4, 5));
  }
}
