package com.huongdanjava.springdatajpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

    StudentRepository studentRepository = (StudentRepository) ac.getBean("studentRepository");

    Student student = studentRepository.findByName("Khanh Nguyen");

    System.out.println(student.getId());
  }
}
