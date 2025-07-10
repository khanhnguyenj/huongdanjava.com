package com.huongdanjava.jobrunr;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.jobrunr.configuration.JobRunr;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.InMemoryStorageProvider;

public class Application {

  public static void main(String[] args) {
    JobScheduler jobScheduler = JobRunr.configure()
        .useStorageProvider(new InMemoryStorageProvider())
        .useBackgroundJobServer()
        .useDashboard()
        .initialize()
        .getJobScheduler();

    jobScheduler.schedule(Instant.now().plus(1, ChronoUnit.MINUTES),
        () -> System.out.println("Hello from Huong Dan Java"));
  }
}
