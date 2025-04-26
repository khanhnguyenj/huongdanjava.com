package com.huongdanjava.liquibase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

public class Application {

  public static void main(String[] args) throws SQLException, LiquibaseException {
    Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5431/liquibase_example",
        "khanh", "123456");

    Database database = DatabaseFactory.getInstance()
        .findCorrectDatabaseImplementation(new JdbcConnection(c));

    Liquibase liquibase = new Liquibase("db-changelog.xml",
        new ClassLoaderResourceAccessor(), database);

    liquibase.update("main");
  }

}
