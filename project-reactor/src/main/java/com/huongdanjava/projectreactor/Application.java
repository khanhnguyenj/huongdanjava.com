package com.huongdanjava.projectreactor;

import reactor.core.publisher.Mono;

public class Application {

	public static void main(String[] args) {
		Mono<String> mono1 = Mono.just("Khanh");

		Mono<Integer> mono2 = mono1.flatMap(s -> {
			return Mono.just(new Integer(s.length()));
		});

		Integer integer = mono2.block();

		System.out.println(integer);
	}

}
