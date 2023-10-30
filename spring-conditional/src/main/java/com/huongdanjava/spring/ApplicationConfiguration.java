package com.huongdanjava.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional({ConditionalImpl.class, AnotherConditionalImpl.class})
public class ApplicationConfiguration {

  @Bean
  public Student student() {
    return new Student("Khanh");
  }

  @Bean
  public Clazz clazz() {
    return new Clazz("A");
  }

}
