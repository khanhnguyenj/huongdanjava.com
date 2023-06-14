package com.huongdanjava.opentelemetry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;

@RestController
public class HelloController {

  private Meter meter = GlobalOpenTelemetry.meterBuilder("io.opentelemetry.metrics.hello")
      .build();

  private LongCounter counter = meter.counterBuilder("helloCounter")
      .build();

  @GetMapping("/hello")
  public String hello() {
    counter.add(1);
    return "Hello";
  }

}