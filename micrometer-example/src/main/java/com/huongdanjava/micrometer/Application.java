package com.huongdanjava.micrometer;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import java.util.concurrent.atomic.AtomicInteger;

public class Application {

  static void main() {
    MeterRegistry registry = new SimpleMeterRegistry();

    AtomicInteger activeConnections = new AtomicInteger(0);

    Gauge.builder("connections.active", activeConnections, AtomicInteger::get)
        .description("Active connections")
        .register(registry);

    activeConnections.incrementAndGet();
    activeConnections.incrementAndGet();

    System.out.println(
        "Active connections = " + registry.get("connections.active").gauge().value());

    activeConnections.decrementAndGet();

    System.out.println(
        "Active connections = " + registry.get("connections.active").gauge().value());
  }
}
