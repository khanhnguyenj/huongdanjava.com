package com.huongdanjava.testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Application {

  public static void main(String[] args) throws SQLException {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
        "root", "123456");
    StudentService studentService = new StudentService();
    List<Student> students = studentService.getAllStudents(connection);

    students.forEach(s -> {
      System.out.println("ID: " + s.id()  + ", name: " + s.name());
    });
  }
}
