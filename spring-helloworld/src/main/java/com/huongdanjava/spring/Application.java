package com.huongdanjava.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  static void main(String[] args) {
    // Call Spring container
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    // Request to get SayHello object
    SayHello sayHello = (SayHello) context.getBean("hello");

    // Call any methods in SayHello object
    sayHello.say();

//    XmlBeanDefinitionReader
//    DefaultListableBeanFactory

//    BeanDefinitionParserDelegate

//    BeanFactory
//    AbstractAutowireCapableBeanFactory
  }
}
