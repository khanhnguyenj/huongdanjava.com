package com.huongdanjava.systemdesign.sagapattern.paymentservice;

import lombok.Data;

@Data
public class Order {
  private Long id;
  private Long price;
  private String status;
  private String source;
  private Long customerId;
}
