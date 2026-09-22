package com.huongdanjava.systemdesign.sagapattern.orderservice.exception;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String message) {
    super(message);
  }
}
