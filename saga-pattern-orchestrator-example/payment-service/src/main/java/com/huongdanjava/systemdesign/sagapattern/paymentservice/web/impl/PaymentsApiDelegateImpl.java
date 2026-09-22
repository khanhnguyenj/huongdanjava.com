package com.huongdanjava.systemdesign.sagapattern.paymentservice.web.impl;

import com.huongdanjava.systemdesign.sagapattern.paymentservice.domain.Payment;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.service.PaymentService;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.web.PaymentsApiDelegate;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.web.dto.PaymentRequest;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.web.dto.PaymentResponse;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.web.mapper.PaymentWebMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentsApiDelegateImpl implements PaymentsApiDelegate {

  private PaymentService paymentService;

  private PaymentWebMapper paymentMapper;

  @Override
  public ResponseEntity<PaymentResponse> payment(PaymentRequest paymentRequest) {
    log.info("Request for payment {}", paymentRequest);

    Payment payment = paymentMapper.toPayment(paymentRequest);
    log.debug("Payment {}", payment);

    Payment p =
        paymentService.process(payment, Boolean.TRUE.equals(paymentRequest.getSimulateFailure()));
    log.debug("Payment {}", p);

    PaymentResponse paymentResponse = paymentMapper.toPaymentResponse(p);
    log.info("Response for payment {}", paymentResponse);

    return ResponseEntity.ok(paymentResponse);
  }
}
