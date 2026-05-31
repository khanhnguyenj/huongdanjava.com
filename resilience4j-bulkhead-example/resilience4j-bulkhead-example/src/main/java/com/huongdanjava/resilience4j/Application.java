package com.huongdanjava.resilience4j;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadConfig;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadRegistry;
import io.github.resilience4j.bulkhead.internal.SemaphoreBulkhead;
import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Application {

  static void main() throws InterruptedException {
//    BulkheadConfig config = BulkheadConfig.custom()
//        .maxConcurrentCalls(2)
//        .maxWaitDuration(Duration.ofMillis(1))
//        .build();
//
//    BulkheadRegistry registry = BulkheadRegistry.of(config);
//
//    Bulkhead bulkhead = registry.bulkhead("hello");
//
//    Supplier<String> decoratedSupplier = Bulkhead
//        .decorateSupplier(bulkhead, Application::callExternalService);
//
//    try (ExecutorService executor = Executors.newFixedThreadPool(5)) {
//      for (int i = 1; i <= 5; i++) {
//        int taskId = i;
//        executor.submit(() -> {
//          try {
//            String result = decoratedSupplier.get();
//            System.out.println("Task " + taskId + " succeeded with result: " + result);
//          } catch (Exception e) {
//            System.out.println("Task " + taskId + " rejected: " + e.getMessage());
//          }
//        });
//      }
//
//      executor.shutdown();
//    }

    ThreadPoolBulkheadConfig config = ThreadPoolBulkheadConfig.custom()
        .maxThreadPoolSize(2)
        .coreThreadPoolSize(2)
        .queueCapacity(2)
        .build();

    ThreadPoolBulkheadRegistry registry = ThreadPoolBulkheadRegistry.of(config);

    ThreadPoolBulkhead bulkhead = registry.bulkhead("hello");

    Supplier<CompletionStage<String>> decoratedSupplier = ThreadPoolBulkhead
        .decorateSupplier(bulkhead, Application::callExternalService);

    for (int i = 1; i <= 5; i++) {
      int taskId = i;

      decoratedSupplier.get().whenComplete((result, throwable) -> {
        if (throwable != null) {
          System.out.println("Task " + taskId + " rejected: " + throwable.getMessage());
        } else {
          System.out.println("Task " + taskId + " succeeded with result: " + result);
        }
      });
    }

    Thread.sleep(10000);
  }

  private static String callExternalService() {
    try {
      System.out.println(Thread.currentThread().getName() + " is calling external API...");
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    return "OK";
  }

}
