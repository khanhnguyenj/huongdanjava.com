package com.huongdanjava.flyway;

import org.flywaydb.core.Flyway;

public class Application {

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
            .dataSource("jdbc:postgresql://localhost:5432/student", "postgres", "123456")
            .load();

        flyway.migrate();
    }

}
