package com.huongdanjava.systemdesign.sagapattern.orderservice.repository.mapper;

import com.huongdanjava.systemdesign.sagapattern.orderservice.domain.Order;
import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  OrderEntity toEntity(Order orderRequest);

  Order toDomain(OrderEntity saved);
}
