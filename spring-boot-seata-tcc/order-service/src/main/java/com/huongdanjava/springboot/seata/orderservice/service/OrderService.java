package com.huongdanjava.springboot.seata.orderservice.service;

import com.huongdanjava.springboot.seata.orderservice.controller.dto.OrderRequest;

public interface OrderService {

  void order(OrderRequest order);
}
