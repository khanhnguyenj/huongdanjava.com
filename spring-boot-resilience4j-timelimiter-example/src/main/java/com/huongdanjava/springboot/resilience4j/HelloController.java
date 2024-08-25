package com.huongdanjava.springboot.resilience4j;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import java.util.concurrent.CompletableFuture;
import java.util.random.RandomGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  @TimeLimiter(name = "hello", fallbackMethod = "fallback")
  public CompletableFuture<String> hello() {
    return CompletableFuture.supplyAsync(() -> {
      try {
        return response();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
  }

  private String response() throws InterruptedException {
    if (RandomGenerator.getDefault().nextBoolean()) {
      Thread.sleep(10000);
    }
    return "Hello from Huong Dan Java";
  }

  private CompletableFuture<String> fallback(Throwable throwable) {
    return CompletableFuture.supplyAsync(() -> "Hello World");
  }

}
