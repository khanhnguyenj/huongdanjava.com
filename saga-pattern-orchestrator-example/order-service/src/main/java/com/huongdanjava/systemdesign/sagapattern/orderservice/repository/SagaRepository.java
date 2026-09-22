package com.huongdanjava.systemdesign.sagapattern.orderservice.repository;

import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity.SagaInstanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SagaRepository extends JpaRepository<SagaInstanceEntity, Long> {}
