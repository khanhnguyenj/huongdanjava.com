package com.huongdanjava.testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class StudentServiceTest {

  private StudentService studentService = new StudentService();

  private static Connection connection;

  @Container
  public static MySQLContainer<?> container = new MySQLContainer<>("mysql:latest")
      .withDatabaseName("example")
      .withPassword("123456")
      .withInitScript("db.sql")
      .withReuse(true);

  @BeforeAll
  public static void init() throws SQLException {
    container.start();

    connection = DriverManager.getConnection(container.getJdbcUrl(),
        "root", "123456");
  }

  @Test
  public void testGetAllStudents() throws SQLException {
    List<Student> allStudents = studentService.getAllStudents(connection);
    Assertions.assertTrue(allStudents.size() == 2);
  }
}
