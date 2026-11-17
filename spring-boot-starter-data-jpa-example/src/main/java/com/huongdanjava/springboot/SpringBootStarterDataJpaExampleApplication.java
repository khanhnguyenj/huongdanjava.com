package com.huongdanjava.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootStarterDataJpaExampleApplication {

  static void main(String[] args) {
    SpringApplication.run(SpringBootStarterDataJpaExampleApplication.class, args);
  }

  @Bean
  CommandLineRunner init(StudentRepository studentRepository) {
    return args -> {
      Student student = studentRepository.findByName("Khanh Nguyen");
      System.out.println(student.getId());
    };
  }
}
