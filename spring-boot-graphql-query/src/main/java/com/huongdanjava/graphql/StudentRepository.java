package com.huongdanjava.graphql;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface StudentRepository extends R2dbcRepository<Student, Long> {

}
