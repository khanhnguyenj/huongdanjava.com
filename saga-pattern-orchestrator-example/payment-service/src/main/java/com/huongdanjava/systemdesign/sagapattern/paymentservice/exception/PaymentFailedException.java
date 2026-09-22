package com.huongdanjava.systemdesign.sagapattern.paymentservice.exception;

public class PaymentFailedException extends RuntimeException {

  public PaymentFailedException(String message) {
    super(message);
  }
}
