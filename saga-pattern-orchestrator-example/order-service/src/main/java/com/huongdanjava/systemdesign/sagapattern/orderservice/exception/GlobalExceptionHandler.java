package com.huongdanjava.systemdesign.sagapattern.orderservice.exception;

import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.AddNewOrderResponse;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.InlineObject;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.InlineObjectAllOfDataInner;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<AddNewOrderResponse> productNotFoundException(
      Exception ex, WebRequest request) {
    log.debug(ex.getMessage(), ex);

    AddNewOrderResponse response = new AddNewOrderResponse(false);
    response.setMessage(ex.getMessage());

    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<InlineObject> methodArgumentNotValidException(
      MethodArgumentNotValidException ex, WebRequest request) {
    log.debug(ex.getMessage(), ex);

    List<FieldError> errors = ex.getBindingResult().getFieldErrors();

    List<InlineObjectAllOfDataInner> validationErrors =
        errors.stream()
            .map(
                error ->
                    new InlineObjectAllOfDataInner(error.getField(), error.getDefaultMessage()))
            .toList();

    InlineObject response = new InlineObject(false);
    response.setMessage("Request validation failed");
    response.setData(validationErrors);

    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<AddNewOrderResponse> exception(Exception ex, WebRequest request) {
    log.error(ex.getMessage(), ex);

    return ResponseEntity.internalServerError().build();
  }
}
