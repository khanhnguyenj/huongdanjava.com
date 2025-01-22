package com.huongdanjava.springapachekafka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) throws InterruptedException {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfiguration.class);

    Thread.sleep(100000);
  }

}
