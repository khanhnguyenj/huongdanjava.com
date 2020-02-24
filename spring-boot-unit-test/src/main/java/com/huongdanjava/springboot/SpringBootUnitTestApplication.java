package com.huongdanjava.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootUnitTestApplication implements CommandLineRunner {

  @Autowired
  private Hello hello;

  @Autowired
  private Calculation calculation;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootUnitTestApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(String.format("%s. Total of 2 and 3 is %s", hello.say("Khanh"), calculation.sum(2, 3)));
  }

}
