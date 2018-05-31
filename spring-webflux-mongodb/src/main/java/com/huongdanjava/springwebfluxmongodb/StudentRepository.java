package com.huongdanjava.springwebfluxmongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveMongoRepository<Student, String> {

	@Tailable
	Flux<Student> findBy();

}
