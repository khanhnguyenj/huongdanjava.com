package com.huongdanjava.springboot.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

//@Component
public class AppHealthIndicator implements HealthIndicator {

  @Override
  public Health health() {
    return Health.down().build();
  }
}
