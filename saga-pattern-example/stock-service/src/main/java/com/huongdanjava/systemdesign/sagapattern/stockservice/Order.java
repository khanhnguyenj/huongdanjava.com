package com.huongdanjava.systemdesign.sagapattern.stockservice;

import lombok.Data;

@Data
public class Order {
  private Long id;
  private Long price;
  private String status;
  private String source;
  private Long customerId;
  private Long productCount;
  private Long productId;
}
