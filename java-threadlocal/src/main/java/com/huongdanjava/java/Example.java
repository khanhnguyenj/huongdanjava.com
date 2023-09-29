package com.huongdanjava.java;

public class Example {

  public static void main(String[] args) {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    threadLocal.set("Huong Dan Java");

    System.out.println(threadLocal.get());

    threadLocal.remove();

    System.out.println(threadLocal.get());
  }
}
