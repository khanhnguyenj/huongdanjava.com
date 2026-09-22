package com.huongdanjava.systemdesign.sagapattern.orderservice.client;

import com.huongdanjava.systemdesign.sagapattern.web.dto.PaymentRequest;
import com.huongdanjava.systemdesign.sagapattern.web.dto.PaymentResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/api/payments")
public interface PaymentClient {

  @PostExchange
  PaymentResponse charge(@RequestBody PaymentRequest request);
}
