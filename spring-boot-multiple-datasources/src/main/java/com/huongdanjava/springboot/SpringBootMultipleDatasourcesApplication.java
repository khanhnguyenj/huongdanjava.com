package com.huongdanjava.springboot;

import com.huongdanjava.springboot.mysql.repository.StudentRepository;
import com.huongdanjava.springboot.postgresql.repository.ClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMultipleDatasourcesApplication implements CommandLineRunner {

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  ClazzRepository clazzRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMultipleDatasourcesApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Getting all students from MySQL database ...");
    studentRepository.findAll().forEach(s -> System.out.println(s.getName()));

    System.out.println("Getting all classes from PostgreSQL database ...");
    clazzRepository.findAll().forEach(c -> System.out.println(c.getName()));
  }
}