package com.huongdanjava.java;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SerializableDemo {
  static void main() throws SQLException, InterruptedException {
    try (Connection connection1 =
            DriverManager.getConnection("jdbc:mysql://localhost:3307/example", "root", "123456");
        Connection connection2 =
            DriverManager.getConnection("jdbc:mysql://localhost:3307/example", "root", "123456")) {

      connection1.setAutoCommit(false);
      connection1.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

      // Read all accounts in database in transaction 1
      System.out.println("First read:");
      readAllAccounts(connection1);

      connection2.setAutoCommit(false);
      connection2.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

      // Add new account C in transaction 2 and commit
      Thread thread =
          new Thread(
              () -> {
                try {
                  addNewAccount(connection2, "C", BigDecimal.valueOf(1000));
                  connection2.commit();
                } catch (SQLException e) {
                  e.printStackTrace();
                }
              });
      thread.start();

      connection1.commit();

      thread.join();

      connection1.setAutoCommit(false);

      // Read all accounts in database again in transaction 1
      System.out.println("Second read:");
      readAllAccounts(connection1);
      connection1.commit();
    }
  }

  private static void readAllAccounts(Connection connection) throws SQLException {
    try (PreparedStatement statement =
        connection.prepareStatement(
            """
            SELECT *
            FROM account
            """)) {

      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          String account = resultSet.getString("name");
          BigDecimal balance = resultSet.getBigDecimal("balance");

          System.out.println(
              Thread.currentThread().getName() + ": name = " + account + ", balance = " + balance);
        }
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

  private static void addNewAccount(Connection connection, String accountName, BigDecimal balance)
      throws SQLException {
    try (PreparedStatement statement =
        connection.prepareStatement(
            """
        INSERT INTO account
        SET name = ?, balance = ?
        """)) {

      statement.setString(1, accountName);
      statement.setBigDecimal(2, balance);

      statement.executeUpdate();
    }
  }
}
