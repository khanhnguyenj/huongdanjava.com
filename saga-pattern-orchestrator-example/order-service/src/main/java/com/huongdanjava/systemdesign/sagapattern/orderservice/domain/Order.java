package com.huongdanjava.systemdesign.sagapattern.orderservice.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Order {
  private Long id;

  private UUID orderNumber;

  private Long customerId;

  private String paymentMethod;

  private List<OrderItem> items;

  private OrderStatus status;

  private BigDecimal totalAmount;

  private String currency;
}
