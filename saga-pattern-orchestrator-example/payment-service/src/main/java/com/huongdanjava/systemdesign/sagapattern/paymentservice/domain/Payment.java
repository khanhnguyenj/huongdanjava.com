package com.huongdanjava.systemdesign.sagapattern.paymentservice.domain;

import java.util.UUID;
import lombok.Data;

@Data
public class Payment {

  private Long id;

  private String sagaId;

  private UUID orderNumber;

  private Integer customerId;

  private Integer amount;

  private String currency;

  private String paymentMethod;

  private PaymentStatus status;
}
