package com.huongdanjava.springboot.resilience4j;

import java.util.concurrent.TimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalErrorHandler {

  @ExceptionHandler(TimeoutException.class)
  @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
  public void handleTimeoutException() {
    System.out.println("Request timed out");
  }
}
