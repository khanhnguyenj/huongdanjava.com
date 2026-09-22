package com.huongdanjava.systemdesign.sagapattern.orderservice.domain;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderItem {
  private Long id;

  private Long orderId;

  private Integer productId;

  private String productName;

  private BigDecimal unitPrice;

  private Integer quantity;

  private BigDecimal totalPrice;
}
