package com.huongdanjava.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
        ApplicationConfiguration.class);

    HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
    helloWorld.print();
  }
}