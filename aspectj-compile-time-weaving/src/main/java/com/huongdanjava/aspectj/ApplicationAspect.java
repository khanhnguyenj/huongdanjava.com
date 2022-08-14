package com.huongdanjava.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ApplicationAspect {

  @After("execution (* com.huongdanjava.aspectj.HelloWorld.*(..))")
  public void allMethods() {
    System.out.println(", Khanh");
  }

}
