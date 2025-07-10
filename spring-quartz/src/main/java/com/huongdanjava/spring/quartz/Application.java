package com.huongdanjava.spring.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
  }

}
