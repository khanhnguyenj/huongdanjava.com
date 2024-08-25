package com.huongdanjava.resilience4j;

import java.util.random.RandomGenerator;

public class Hello {

  public String hello() throws InterruptedException {
    if (RandomGenerator.getDefault().nextBoolean()) {
      Thread.sleep(10000);
      System.out.println("Resumed");
    }

    return "Hello from Huong Dan Java";
  }

}
