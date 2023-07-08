package com.huongdanjava.springdatajpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

    StudentRepository studentRepository = (StudentRepository) ac.getBean("studentRepository");
    List<Student> students = studentRepository.findByClazzOrderByNameDesc("A");
    students.forEach(s -> System.out.println(s.getName()));
  }
}
