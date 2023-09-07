package com.huongdanjava.projectreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Application {

  public static void main(String[] args) {
    Flux<String> flux = Flux.just("Khanh", "Quan");

    flux.flatMap(s -> Mono.just(s.length()))
        .map(value -> {
          System.out.println(value);
          return value;
        })
        .subscribe();
  }

}
