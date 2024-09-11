package com.huongdanjava.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    CircuitBreakerRegistry circuitBreakerRegistry
        = CircuitBreakerRegistry.ofDefaults();
  }
}