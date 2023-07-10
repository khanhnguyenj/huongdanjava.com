package com.huongdanjava.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSpringDataR2dbcExampleApplication implements CommandLineRunner {

  @Autowired
  StudentRepository studentRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootSpringDataR2dbcExampleApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    studentRepository.findAll().log()
        .map(s -> {
          System.out.println(s.getName());
          return s;
        })
        .subscribe();

    Thread.sleep(10000);
  }
}
