package com.huongdanjava.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {

  public static void main(String[] args) throws SQLException {
    try (Connection connection =
            DriverManager.getConnection("jdbc:mysql://localhost:3307/example", "root", "123456");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM clazz")) {

      while (rs.next()) {
        System.out.print(rs.getInt("id") + "-");
        System.out.print(rs.getString("name") + "\n");
      }
    }
  }
}
