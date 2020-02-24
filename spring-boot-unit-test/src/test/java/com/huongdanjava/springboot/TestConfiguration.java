package com.huongdanjava.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

  @Bean
  public Hello hello() {
    return new Hello();
  }
}
