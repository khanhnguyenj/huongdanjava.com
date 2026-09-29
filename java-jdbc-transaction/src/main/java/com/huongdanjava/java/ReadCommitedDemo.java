package com.huongdanjava.java;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadCommitedDemo {
  static void main() throws SQLException {
    try (Connection connection1 =
            DriverManager.getConnection("jdbc:mysql://localhost:3307/example", "root", "123456");
        Connection connection2 =
            DriverManager.getConnection("jdbc:mysql://localhost:3307/example", "root", "123456")) {

      connection1.setAutoCommit(false);

      // Update account A in transaction 1 but not committed yet
      updateBalance(connection1, BigDecimal.valueOf(500));

      connection2.setAutoCommit(false);
      connection2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

      // Read account A in transaction 2
      readBalance(connection2);

      connection1.rollback();

      readBalance(connection2);
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
