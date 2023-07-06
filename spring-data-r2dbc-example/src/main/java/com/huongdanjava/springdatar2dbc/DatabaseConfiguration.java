package com.huongdanjava.springdatar2dbc;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
public class DatabaseConfiguration extends AbstractR2dbcConfiguration {

  @Bean
  public ConnectionFactory connectionFactory() {
    ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
        .option(ConnectionFactoryOptions.DRIVER, "postgresql")
        .option(ConnectionFactoryOptions.HOST, "localhost")
        .option(ConnectionFactoryOptions.USER, "khanh")
        .option(ConnectionFactoryOptions.PASSWORD, "123456")
        .option(ConnectionFactoryOptions.DATABASE, "spring_data_r2dbc_example")
        .build();

    return ConnectionFactories.get(options);
  }

}
