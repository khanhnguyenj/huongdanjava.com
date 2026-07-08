package com.huongdanjava.systemdesign.sagapattern.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication(nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
@ComponentScan(
    basePackages = {"org.openapitools", "com.huongdanjava.systemdesign.sagapattern.orderservice"},
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
public class OrderServiceApplication {

  static void main(String[] args) {
    SpringApplication.run(OrderServiceApplication.class, args);
  }
}
