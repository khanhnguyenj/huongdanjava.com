package com.huongdanjava.systemdesign.sagapattern.paymentservice.service;

import com.huongdanjava.systemdesign.sagapattern.paymentservice.domain.Payment;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.domain.PaymentStatus;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.exception.PaymentFailedException;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.repository.PaymentRepository;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.repository.entity.PaymentEntity;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.repository.mapper.PaymentRepositoryMapper;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {

  private PaymentRepository paymentRepository;

  private PaymentRepositoryMapper paymentMapper;

  public Payment process(Payment paymentRequest, boolean isSimulateFailure) {
    PaymentEntity paymentEntity = paymentMapper.toEntity(paymentRequest);
    paymentEntity.setCreatedAt(Instant.now());
    paymentEntity.setUpdatedAt(Instant.now());

    if (isSimulateFailure) {
      paymentEntity.setStatus(PaymentStatus.FAILED);
      paymentRepository.save(paymentEntity);

      throw new PaymentFailedException("Payment processing failed");
    }

    paymentEntity.setStatus(PaymentStatus.SUCCESS);
    paymentRepository.save(paymentEntity);

    return paymentMapper.toDomain(paymentEntity);
  }
}
