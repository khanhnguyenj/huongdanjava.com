package com.huongdanjava.springkafka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
  static void main(){
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class, OrderStreamTopology.class);
  }
}
