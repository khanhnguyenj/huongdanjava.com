package com.huongdanjava.systemdesign.sagapattern.stockservice.exception;

public class ProductStockNotFoundException extends RuntimeException {

  public ProductStockNotFoundException(String message) {
    super(message);
  }
}
