package com.huongdanjava.springboot.seata.orderservice.service;

import com.huongdanjava.springboot.seata.orderservice.db.OrderEntity;
import com.huongdanjava.springboot.seata.orderservice.db.OrderRepository;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.apache.seata.rm.tcc.api.BusinessActionContext;
import org.apache.seata.rm.tcc.api.BusinessActionContextParameter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderTccServiceImpl implements OrderTccService {

  private OrderRepository orderRepository;

  @Override
  public boolean prepareCreate(BusinessActionContext actionContext,
      @BusinessActionContextParameter(paramName = "orderId") String orderId,
      @BusinessActionContextParameter(paramName = "userId") String userId,
      @BusinessActionContextParameter(paramName = "amount") BigDecimal amount) {

    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setOrderId(orderId);
    orderEntity.setUserId(userId);
    orderEntity.setAmount(amount);
    orderEntity.setStatus("PENDING");

    orderRepository.save(orderEntity);

    return true;
  }

  @Override
  public boolean confirm(BusinessActionContext ctx) {
    String orderId = (String) ctx.getActionContext("orderId");

    orderRepository.updateStatusByOrderId("CONFIRMED", orderId);

    return true;
  }

  @Override
  public boolean cancel(BusinessActionContext ctx) {
    String orderId = (String) ctx.getActionContext("orderId");
    orderRepository.updateStatusByOrderId("FAILED", orderId);

    return true;
  }
}
