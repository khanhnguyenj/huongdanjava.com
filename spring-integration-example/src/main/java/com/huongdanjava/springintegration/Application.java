package com.huongdanjava.springintegration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  public static void main(String[] args) {
    new ClassPathXmlApplicationContext("spring-integration.xml");
  }

}
