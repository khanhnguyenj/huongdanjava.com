package com.huongdanjava.springboot.seata.orderservice.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

  @Query("update OrderEntity o set o.status = :status where o.orderId = :orderId")
  @Modifying
  @Transactional
  void updateStatusByOrderId(String status, String orderId);
}
