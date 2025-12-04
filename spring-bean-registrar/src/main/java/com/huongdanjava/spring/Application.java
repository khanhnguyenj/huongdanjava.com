package com.huongdanjava.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  static void main() {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    Hello hello = context.getBean("huongdanjava_hello", Hello.class);

    hello.say();
  }

}
