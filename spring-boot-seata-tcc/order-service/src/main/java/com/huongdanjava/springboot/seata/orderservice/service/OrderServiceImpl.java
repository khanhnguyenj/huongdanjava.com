package com.huongdanjava.springboot.seata.orderservice.service;

import com.huongdanjava.springboot.seata.orderservice.controller.dto.OrderRequest;
import com.huongdanjava.springboot.seata.orderservice.db.OrderEntity;
import com.huongdanjava.springboot.seata.orderservice.db.OrderRepository;
import com.huongdanjava.springboot.seata.orderservice.http.AccountClient;
import com.huongdanjava.springboot.seata.orderservice.http.dto.AmountDeductionRequest;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.apache.seata.rm.tcc.api.BusinessActionContext;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

  private OrderTccService orderTccService;

  private AccountClient accountClient;

  @GlobalTransactional
  public void order(OrderRequest order) {
    OrderEntity orderEntity = new OrderEntity();
    BeanUtils.copyProperties(order, orderEntity);

    String orderId = UUID.randomUUID().toString();

    orderTccService.prepareCreate(null, orderId, order.userId(), order.amount());

    accountClient.deduct(new AmountDeductionRequest(order.userId(), order.amount()));

    System.out.println("[OrderService] Order placed successfully!");
  }
}
