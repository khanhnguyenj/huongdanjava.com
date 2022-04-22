package com.huongdanjava.springenabletransactionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringEnabletransactionmanagementApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringEnabletransactionmanagementApplication.class, args);
  }

}
