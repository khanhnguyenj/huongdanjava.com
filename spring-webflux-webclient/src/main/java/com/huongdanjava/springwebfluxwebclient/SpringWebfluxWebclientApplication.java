package com.huongdanjava.springwebfluxwebclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringWebfluxWebclientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxWebclientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String url = "http://localhost:8080";

		WebClient webClient = WebClient.builder().baseUrl(url).build();

		Flux<String> flux = webClient.get()
		    .uri("/students")
		    .retrieve()
		    .bodyToFlux(String.class);

		flux.subscribe(s -> System.out.println(s));
	}
}
