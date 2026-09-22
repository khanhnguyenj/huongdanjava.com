package com.huongdanjava.systemdesign.sagapattern.orderservice.repository;

import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {}
