package com.huongdanjava.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDockerComposeSupportApplication {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  @Qualifier("jdbcConnectionDetailsForSpringBootDockerComposeSupportPostgres1")
  private ConnectionDetails connectionDetails;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDockerComposeSupportApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println(((JdbcConnectionDetails) connectionDetails).getJdbcUrl());
    };
  }

}
