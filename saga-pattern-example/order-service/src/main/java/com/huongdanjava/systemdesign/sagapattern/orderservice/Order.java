package com.huongdanjava.systemdesign.sagapattern.orderservice;

import lombok.Data;

@Data
public class Order {
  private Long orderId;
  private String status;
}
