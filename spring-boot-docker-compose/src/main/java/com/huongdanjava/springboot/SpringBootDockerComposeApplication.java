package com.huongdanjava.springboot;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@SpringBootApplication
@RestController
public class SpringBootDockerComposeApplication {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(SpringBootDockerComposeApplication.class);

  @Autowired
  private DataSource dataSource;

  @GetMapping("/hello")
  public String helloDockerCompose() {
    LOGGER.info("Received request ...");

    Integer idleConnection = new HikariDataSourcePoolMetadata(
        (HikariDataSource) dataSource).getIdle();

    return "Hello Docker Compose! Idle connection to database is " + idleConnection;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDockerComposeApplication.class, args);
  }

}
