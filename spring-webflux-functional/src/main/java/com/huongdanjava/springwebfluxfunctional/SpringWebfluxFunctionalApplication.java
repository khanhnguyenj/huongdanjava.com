package com.huongdanjava.springwebfluxfunctional;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import java.time.Duration;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

@SpringBootApplication
public class SpringWebfluxFunctionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxFunctionalApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return route(GET("/students"), (request) -> ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(all(), Student.class));
	}

	private Flux<Student> all() {
		RandomStringGenerator rsg = new RandomStringGenerator.Builder()
			.withinRange('a', 'z')
			.build();

		return Flux.generate((SynchronousSink<Student> sink) -> sink.next(new Student(rsg.generate(10))))
			.delayElements(Duration.ofSeconds(1L));
	}
}
