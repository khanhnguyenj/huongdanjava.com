package com.huongdanjava.jakartaee;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

// @WebListener
public class HuongDanJavaServletContextListener implements ServletContextListener {

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("contextDestroyed");
  }

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("contextInitialized");
  }
}
