package com.huongdanjava.systemdesign.sagapattern.stockservice.exception;

public class StockReservationNotFoundException extends RuntimeException {

  public StockReservationNotFoundException(String message) {
    super(message);
  }
}
