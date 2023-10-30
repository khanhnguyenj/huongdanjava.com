package com.huongdanjava.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    Clazz clazz = (Clazz) context.getBean("clazz");
    System.out.println(clazz.name());

    Student student = (Student) context.getBean("student");
    System.out.println(student.name());
  }

}
