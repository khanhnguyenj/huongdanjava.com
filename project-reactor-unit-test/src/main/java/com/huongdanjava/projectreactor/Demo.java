package com.huongdanjava.projectreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Demo {

  public Mono<String> getStudentName() {
    return Mono.just("Khanh");
  }

  public Flux<String> getStudentNames() {
    return Flux.just("Khanh", "Quan");
  }
}
