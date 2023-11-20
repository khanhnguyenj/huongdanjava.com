package com.huongdanjava.springboot.postgresql;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = {"com.huongdanjava.springboot.postgresql.repository"},
    entityManagerFactoryRef = "postgresqlEntityManagerFactory",
    transactionManagerRef = "postgresqlTransactionManager"
)
public class PostgreSQLDatabaseConfiguration {

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "postgresql.datasource")
  public DataSource postgresqlDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(
      EntityManagerFactoryBuilder builder) {
    return builder
        .dataSource(postgresqlDataSource())
        .packages("com.huongdanjava.springboot.postgresql.entity")
        .build();
  }

  @Bean
  public PlatformTransactionManager postgresqlTransactionManager(
      EntityManagerFactory postgresqlEntityManagerFactory) {
    return new JpaTransactionManager(postgresqlEntityManagerFactory);
  }
}