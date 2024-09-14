package com.huongdanjava.resilience4j;

public class Hello {

  private int failedTimes;

  private int maximumFailedTimes;

  public Hello(int maximumFailedTimes) {
    this.maximumFailedTimes = maximumFailedTimes;
  }

  public String hello() {
    System.out.println("hello() called ...");
    if (failedTimes < maximumFailedTimes) {
      failedTimes++;
      throw new RuntimeException("Something went wrong");
    }

    return "Hello from Huong Dan Java";
  }

}
