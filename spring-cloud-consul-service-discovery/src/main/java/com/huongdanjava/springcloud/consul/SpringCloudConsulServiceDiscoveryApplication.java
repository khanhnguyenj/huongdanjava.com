package com.huongdanjava.springcloud.consul;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudConsulServiceDiscoveryApplication {

  @Autowired
  private DiscoveryClient discoveryClient;

  static void main(String[] args) {
    SpringApplication.run(SpringCloudConsulServiceDiscoveryApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
      List<ServiceInstance> instances = discoveryClient.getInstances("huongdanjava-service");
      System.out.println(instances.getFirst().getUri());
    };
  }

}
