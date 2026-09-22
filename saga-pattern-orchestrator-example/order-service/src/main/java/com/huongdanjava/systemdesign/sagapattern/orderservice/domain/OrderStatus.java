package com.huongdanjava.systemdesign.sagapattern.orderservice.domain;

public enum OrderStatus {
  STOCK_RESERVED,
  PAYMENT_PROCESSING,
  CONFIRMED,
  CANCELLED,
  PENDING
}
