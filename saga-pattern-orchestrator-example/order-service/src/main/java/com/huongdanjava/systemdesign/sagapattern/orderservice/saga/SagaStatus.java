package com.huongdanjava.systemdesign.sagapattern.orderservice.saga;

public enum SagaStatus {
  STARTED,
  RUNNING,
  COMPLETED,
  COMPENSATING,
  CANCELLED,
  FAILED
}
