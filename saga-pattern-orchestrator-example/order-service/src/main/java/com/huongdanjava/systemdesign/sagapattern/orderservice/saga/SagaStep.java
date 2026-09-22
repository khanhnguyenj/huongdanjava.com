package com.huongdanjava.systemdesign.sagapattern.orderservice.saga;

public enum SagaStep {
  CREATE_ORDER,
  RESERVE_STOCK,
  PROCESS_PAYMENT,
  RELEASE_STOCK,
  CANCEL_ORDER,
  COMPLETE_ORDER
}
