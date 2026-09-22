package com.huongdanjava.systemdesign.sagapattern.paymentservice.web.mapper;

import com.huongdanjava.systemdesign.sagapattern.paymentservice.domain.Payment;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.web.dto.PaymentRequest;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.web.dto.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentWebMapper {

  Payment toPayment(PaymentRequest paymentRequest);

  @Mapping(target = "success", constant = "true")
  @Mapping(target = "data.sagaId", source = "payment.sagaId")
  @Mapping(target = "data.paymentId", source = "payment.id")
  @Mapping(target = "data.orderNumber", source = "payment.orderNumber")
  PaymentResponse toPaymentResponse(Payment payment);
}
