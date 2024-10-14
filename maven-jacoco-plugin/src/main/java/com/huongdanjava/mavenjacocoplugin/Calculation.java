package com.huongdanjava.mavenjacocoplugin;

public class Calculation {

  public int add(int a, int b) {
    return a + b;
  }

  public int sub(int a, int b) {
    if (a >= b) {
      return a - b;
    }

    return b - a;
  }

}
