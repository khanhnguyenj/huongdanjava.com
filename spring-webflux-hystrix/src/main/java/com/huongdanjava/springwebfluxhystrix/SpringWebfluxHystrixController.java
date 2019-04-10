package com.huongdanjava.springwebfluxhystrix;

import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class SpringWebfluxHystrixController {

    @RequestMapping(value = "/consume-hello")
    public String findAll() {
    	String url = "http://localhost:8080";
    	WebClient webClient = WebClient.builder().baseUrl(url).build();

    	Flux<String> flux = webClient.get()
    	    .uri("/hello")
    	    .retrieve()
    	    .bodyToFlux(String.class);

    	Flux<String> fluxAsDefault = HystrixCommands.from(flux)
    									.commandName("hello")
    									.fallback(Flux.just("Hello, Khanh Nguyen"))
    									.toFlux();

        return fluxAsDefault.blockFirst();
    }

}
