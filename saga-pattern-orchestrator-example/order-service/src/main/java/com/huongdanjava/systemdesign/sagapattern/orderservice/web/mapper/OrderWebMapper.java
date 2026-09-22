package com.huongdanjava.systemdesign.sagapattern.orderservice.web.mapper;

import com.huongdanjava.systemdesign.sagapattern.orderservice.domain.Order;
import com.huongdanjava.systemdesign.sagapattern.orderservice.domain.OrderItem;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.AddNewOrderRequest;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.AddNewOrderResponse;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.OrderDto;
import com.huongdanjava.systemdesign.sagapattern.orderservice.web.dto.OrderItemDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderWebMapper {

  Order toDomain(AddNewOrderRequest addNewOrderRequest);

  OrderDto toOrderDto(Order order);

  @Mapping(target = "data", source = "order")
  AddNewOrderResponse toAddNewOrderResponseDto(Order order);

  List<OrderItem> toListOrderItemDomain(List<OrderItemDto> orderItemDtos);

  OrderItem toOrderItemDomain(OrderItemDto orderItem);
}
