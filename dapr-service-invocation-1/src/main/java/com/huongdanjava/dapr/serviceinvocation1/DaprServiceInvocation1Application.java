package com.huongdanjava.dapr.serviceinvocation1;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaprServiceInvocation1Application implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    try (HttpClient httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .connectTimeout(Duration.ofSeconds(10))
        .build()) {
      String daprUrl = "http://localhost:3500/hello";

      HttpRequest request = HttpRequest.newBuilder()
          .GET()
          .uri(URI.create(daprUrl))
          .header("Content-Type", "application/json")
          .header("dapr-app-id", "service2")
          .build();

      HttpResponse<String> response = httpClient.send(request,
          HttpResponse.BodyHandlers.ofString());
      System.out.println("Response: " + response.body());
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(DaprServiceInvocation1Application.class, args);
  }

}
