package com.huongdanjava.springboot.springbootconditionalonbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootConditionalonbeanApplication implements CommandLineRunner {

  @Autowired
  private Student student;

  public static void main(String[] args) {
    SpringApplication.run(SpringbootConditionalonbeanApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(student.name());
  }
}
