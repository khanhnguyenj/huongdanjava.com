package com.huongdanjava.systemdesign.sagapattern.stockservice.web.mapper;

import com.huongdanjava.systemdesign.sagapattern.stockservice.domain.StockReservation;
import com.huongdanjava.systemdesign.sagapattern.stockservice.domain.StockReservationItem;
import com.huongdanjava.systemdesign.sagapattern.stockservice.web.dto.StockItemDto;
import com.huongdanjava.systemdesign.sagapattern.stockservice.web.dto.StockReservationRequest;
import com.huongdanjava.systemdesign.sagapattern.stockservice.web.dto.StockReservationResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockReservationWebMapper {

  StockReservation toStockReservation(StockReservationRequest reserveStockRequest);

  @Mapping(target = "success", constant = "true")
  @Mapping(target = "data.items", source = "stockReservation.items")
  @Mapping(target = "data.sagaId", source = "stockReservation.sagaId")
  @Mapping(target = "data.orderNumber", source = "stockReservation.orderNumber")
  @Mapping(target = "data.status", source = "stockReservation.status")
  StockReservationResponse toReserveStockResponse(StockReservation stockReservation);

  StockItemDto toStockItemDto(StockReservationItem stockReservationItem);

  List<StockItemDto> toStockItemDtos(List<StockReservationItem> stockReservationItems);
}
