package com.huongdanjava.javajdbcbasic;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "123456");
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM clazz");

        while (rs.next()) {
            System.out.print(rs.getInt("id") + "-");
            System.out.print(rs.getString("name") + "\n");
        }
    }
}
