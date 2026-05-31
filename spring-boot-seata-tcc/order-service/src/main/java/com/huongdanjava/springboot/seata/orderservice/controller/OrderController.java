package com.huongdanjava.springboot.seata.orderservice.controller;

import com.huongdanjava.springboot.seata.orderservice.controller.dto.OrderRequest;
import com.huongdanjava.springboot.seata.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {

  private OrderService orderService;

  @PostMapping("/orders")
  ResponseEntity<String> createOrder(@RequestBody OrderRequest order) {
    orderService.order(order);

    return ResponseEntity.ok().build();
  }

}
