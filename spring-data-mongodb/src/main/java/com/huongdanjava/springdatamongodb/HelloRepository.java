package com.huongdanjava.springdatamongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HelloRepository extends MongoRepository<Student, String> {

}
