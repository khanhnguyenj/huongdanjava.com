package com.huongdanjava.springboot;

import org.springframework.stereotype.Service;

@Service
public class Calculation {

  public int sum(int a, int b) {
    return a + b;
  }
}
