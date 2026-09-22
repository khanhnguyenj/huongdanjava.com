package com.huongdanjava.systemdesign.sagapattern.orderservice.web.impl;

import com.huongdanjava.systemdesign.sagapattern.orderservice.domain.Order;
import com.huongdanjava.systemdesign.sagapattern.orderservice.service.OrderService;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.OrdersApiDelegate;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.AddNewOrderRequest;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.AddNewOrderResponse;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.mapper.OrderWebMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class OrdersApiDelegateImpl implements OrdersApiDelegate {

  private OrderService orderService;

  private OrderWebMapper orderMapper;

  @Override
  public ResponseEntity<AddNewOrderResponse> addNewOrder(AddNewOrderRequest addNewOrderRequest) {
    log.info("Adding new order: {}", addNewOrderRequest);

    Order orderRequest = orderMapper.toDomain(addNewOrderRequest);
    log.debug("Order: {}", orderRequest);

    Order order =
        orderService.addNewOrder(
            orderRequest, Boolean.TRUE.equals(addNewOrderRequest.getSimulatePaymentFailure()));
    log.debug("Order: {}", order);

    AddNewOrderResponse addNewOrderResponseDto = orderMapper.toAddNewOrderResponseDto(order);
    addNewOrderResponseDto.setSuccess(true);
    log.info("Added new order: {}", addNewOrderResponseDto);

    return ResponseEntity.ok(addNewOrderResponseDto);
  }
}
