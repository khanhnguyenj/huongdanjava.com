package com.huongdanjava.springboot.postgresql.repository;

import com.huongdanjava.springboot.postgresql.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClazzRepository extends JpaRepository<Clazz, Long> {

}