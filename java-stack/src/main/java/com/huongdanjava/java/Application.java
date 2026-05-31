package com.huongdanjava.java;

import java.util.Stack;

public class Application {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    stack.push("Khanh");
    stack.push("Huong Dan Java");

    stack.stream().forEach(System.out::println);

    System.out.println(stack.search("Khanh"));
  }
}
