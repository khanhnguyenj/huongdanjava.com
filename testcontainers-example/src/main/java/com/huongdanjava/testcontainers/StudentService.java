package com.huongdanjava.testcontainers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

  public List<Student> getAllStudents(Connection connection) throws SQLException {
    List<Student> students = new ArrayList<>();
    Statement statement = connection.createStatement();

    ResultSet rs = statement.executeQuery("SELECT * FROM students");
    while (rs.next()) {
      Student student = new Student(rs.getInt("id"), rs.getString("name"));
      students.add(student);
    }

    return students;
  }
}
