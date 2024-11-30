package com.huongdanjava.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootConsoleApplication {

  @Autowired
  private HelloWorld helloWorld;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootConsoleApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      helloWorld.say();
    };
  }
}
