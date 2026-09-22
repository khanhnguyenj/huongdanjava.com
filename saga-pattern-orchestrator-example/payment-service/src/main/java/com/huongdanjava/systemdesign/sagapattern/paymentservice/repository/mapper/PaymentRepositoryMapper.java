package com.huongdanjava.systemdesign.sagapattern.paymentservice.repository.mapper;

import com.huongdanjava.systemdesign.sagapattern.paymentservice.domain.Payment;
import com.huongdanjava.systemdesign.sagapattern.paymentservice.repository.entity.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentRepositoryMapper {

  PaymentEntity toEntity(Payment paymentRequest);

  Payment toDomain(PaymentEntity paymentEntity);
}
