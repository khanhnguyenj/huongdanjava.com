package com.huongdanjava.resilience4j;

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    TimeLimiterConfig config = TimeLimiterConfig.custom()
        .cancelRunningFuture(false)
        .timeoutDuration(Duration.ofMillis(3000))
        .build();

    TimeLimiterRegistry timeLimiterRegistry = TimeLimiterRegistry.of(config);

    TimeLimiter timeLimiter = timeLimiterRegistry.timeLimiter("hello");

    Hello hello = new Hello();

    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    try {
      String result = timeLimiter.executeFutureSupplier(
          () -> scheduler.submit(() -> hello.hello()));

      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    }

    Thread.sleep(12000);

    scheduler.shutdown();

//    Hello hello = new Hello();
//
//    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
//
//    CompletableFuture<String> completableFuture = timeLimiter.executeCompletionStage(scheduler,
//        () -> CompletableFuture.supplyAsync(() -> {
//          try {
//            return hello.hello();
//          } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//          }
//        })).toCompletableFuture();
//
//    completableFuture.whenComplete((r, ex) -> {
//      if (ex != null) {
//        ex.printStackTrace();
//      }
//      completableFuture.thenAccept(System.out::println);
//    });
//
//    System.out.println("End");
//
//    Thread.sleep(11000);
//
//    scheduler.shutdown();
  }
}