package com.huongdanjava.springboot.springbootconditionalonbean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public Clazz clazz() {
    return new Clazz("A");
  }

  @Bean
  @ConditionalOnBean(name = {"clazz"})
  public Student student() {
    return new Student("Khanh");
  }

}
