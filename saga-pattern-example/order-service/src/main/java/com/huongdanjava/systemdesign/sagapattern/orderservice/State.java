package com.huongdanjava.systemdesign.sagapattern.orderservice;

public enum State {
  NEW,
  WAITING_STOCK,
  WAITING_PAYMENT,
  COMPLETED,
  COMPENSATING,
  WAITING_STOCK_RELEASE,
  CANCELLED
}
