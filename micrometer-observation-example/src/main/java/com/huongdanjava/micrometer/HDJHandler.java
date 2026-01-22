package com.huongdanjava.micrometer;

import io.micrometer.observation.Observation;
import io.micrometer.observation.Observation.Context;
import io.micrometer.observation.ObservationHandler;

public class HDJHandler implements ObservationHandler<Context> {

  @Override
  public void onStop(Observation.Context context) {
    Throwable error = context.getError();
    if (error != null) {
      System.out.println("Observation error: " + error.getMessage());
    }

    System.out.println("Observation Tags: " + context.getAllKeyValues());
  }

  @Override
  public boolean supportsContext(Observation.Context context) {
    return true;
  }
}
