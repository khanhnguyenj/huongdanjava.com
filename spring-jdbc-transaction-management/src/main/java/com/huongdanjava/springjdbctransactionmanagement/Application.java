package com.huongdanjava.springjdbctransactionmanagement;

import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.huongdanjava.springjdbctransactionmanagement.service.AccountService;

public class Application {

  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    AccountService as = (AccountService) ctx.getBean("accountServiceImpl");
    as.transfer(1, 2, BigDecimal.valueOf(10));
  }
}
