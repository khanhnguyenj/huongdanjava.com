package com.huongdanjava.springenabletransactionmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableTransactionManagement
public class SpringEnabletransactionmanagementApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(SpringEnabletransactionmanagementApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub

  }

}
