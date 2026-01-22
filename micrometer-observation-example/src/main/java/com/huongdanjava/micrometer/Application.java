package com.huongdanjava.micrometer;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

public class Application {

  static void main() {
    ObservationRegistry observationRegistry = ObservationRegistry.create();
    observationRegistry.observationConfig()
        .observationHandler(
            new HDJHandler()
        );

    Observation observation = Observation.createNotStarted("job.execute", observationRegistry)
        .lowCardinalityKeyValue("website", "Huong Dan Java");
    observation.start();

    try {
      throw new RuntimeException("Job failed");
    } catch (Exception e) {
      observation.error(e);
    } finally {
      observation.stop();
    }
  }
}
