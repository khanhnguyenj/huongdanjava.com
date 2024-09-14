package com.huongdanjava.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import java.time.Duration;
import java.util.function.Supplier;

public class Main {

  public static void main(String[] args) {
    CircuitBreakerConfig config = CircuitBreakerConfig.custom()
        .failureRateThreshold(30)
        .slidingWindowSize(5)
        .waitDurationInOpenState(Duration.ofMillis(2))
        .build();

    CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);

    CircuitBreaker circuitBreaker = registry.circuitBreaker("hello");

    Hello hello = new Hello(2);
    Supplier<String> decorated = CircuitBreaker
        .decorateSupplier(circuitBreaker, hello::hello);

    for (int i = 0; i < 20; i++) {
      System.out.println("CircuitBreaker state is " + circuitBreaker.getState());

      try {
        String s = decorated.get();
        System.out.println(s);
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }
}