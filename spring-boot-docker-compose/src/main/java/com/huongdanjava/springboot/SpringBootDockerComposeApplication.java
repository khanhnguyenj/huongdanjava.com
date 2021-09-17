package com.huongdanjava.springboot;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
@RestController
public class SpringBootDockerComposeApplication {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(SpringBootDockerComposeApplication.class);

  @Autowired
  private DataSource dataSource;

  @RequestMapping("/hello")
  public String helloDockerCompose() {
    LOGGER.info("Received request ...");

    Integer idleConnection =
        new HikariDataSourcePoolMetadata((HikariDataSource) dataSource).getIdle();

    return "Hello Docker Compose! Idle connection to database is " + idleConnection;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDockerComposeApplication.class, args);
  }

}
