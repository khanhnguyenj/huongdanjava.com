package com.huongdanjava.systemdesign.sagapattern.orderservice.saga;

import java.util.UUID;

public class SagaContext {

  private UUID sagaId;

  private Long orderId;

  private SagaStatus status;

  private SagaStep currentStep;
}
