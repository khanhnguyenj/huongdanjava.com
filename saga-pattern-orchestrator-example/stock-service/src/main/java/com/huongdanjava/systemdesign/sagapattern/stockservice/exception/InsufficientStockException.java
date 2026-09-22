package com.huongdanjava.systemdesign.sagapattern.stockservice.exception;

public class InsufficientStockException extends RuntimeException {

  public InsufficientStockException(String message) {
    super(message);
  }
}
