package com.huongdanjava.java;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
  static void main() throws SQLException {
    try (Connection connection =
        DriverManager.getConnection("jdbc:mysql://localhost:3307/example", "root", "123456")) {

      BigDecimal amount = BigDecimal.valueOf(10);
      long accountA = 1;
      long accountB = 2;
      boolean simulateFailed = true;

      try {
        connection.setAutoCommit(false);

        // Debit source account
        try (PreparedStatement statement =
            connection.prepareStatement(
                """
                    UPDATE account
                    SET balance = balance - ?
                    WHERE id = ?
                    """)) {

          statement.setBigDecimal(1, amount);
          statement.setLong(2, accountA);

          statement.executeUpdate();
        }

        if (simulateFailed) {
          throw new RuntimeException("Something went wrong");
        }

        // Credit destination account
        try (PreparedStatement statement =
            connection.prepareStatement(
                """
                    UPDATE account
                    SET balance = balance + ?
                    WHERE id = ?
                    """)) {

          statement.setBigDecimal(1, amount);
          statement.setLong(2, accountB);

          statement.executeUpdate();
        }

        connection.commit();
      } catch (Exception e) {
        connection.rollback();
        throw new RuntimeException(e);
      } finally {
        connection.setAutoCommit(true);
      }
    }
  }

  private static BigDecimal readBalance(Connection connection) throws SQLException {

    try (PreparedStatement statement =
        connection.prepareStatement(
            """
            SELECT balance
            FROM account
            WHERE id = ?
            """)) {

      statement.setLong(1, 1);

      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          BigDecimal balance = resultSet.getBigDecimal("balance");

          System.out.println(Thread.currentThread().getName() + ": balance = " + balance);

          return balance;
        }

        throw new SQLException("Account not found");
      }
    }
  }

  private static void updateBalance(Connection connection, BigDecimal balance) throws SQLException {

    try (PreparedStatement statement =
        connection.prepareStatement(
            """
        UPDATE account
        SET balance = ?
        WHERE id = ?
        """)) {

      statement.setBigDecimal(1, balance);
      statement.setLong(2, 1);

      statement.executeUpdate();
    }
  }
}
