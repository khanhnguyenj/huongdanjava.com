package com.huongdanjava.springdatar2dbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) throws InterruptedException {
    ApplicationContext ac = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);

    StudentRepository studentRepository = (StudentRepository) ac.getBean("studentRepository");
    studentRepository.findAll().log()
        .map(s -> {
          System.out.println(s.getName());
          return s;
        })
        .subscribe();

    Thread.sleep(10000);
  }

}