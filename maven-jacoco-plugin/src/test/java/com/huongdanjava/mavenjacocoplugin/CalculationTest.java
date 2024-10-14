package com.huongdanjava.mavenjacocoplugin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculationTest {

  private static Calculation calculation;

  @BeforeAll
  public static void init() {
    calculation = new Calculation();
  }

  @Test
  public void testAdd() {
    assertEquals(4, calculation.add(1, 3));
  }

  @Test
  public void testSub() {
    assertEquals(2, calculation.sub(7, 5));

    assertEquals(9, calculation.sub(3, 12));
  }

}
