package com.huongdanjava.spring;

import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    AccountService as = (AccountService) ctx.getBean("accountServiceImpl");
    as.transfer(1, 2, BigDecimal.valueOf(20));
  }

}
