package com.huongdanjava.springboot.seata.accountservice.exception;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
