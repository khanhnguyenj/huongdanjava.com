package com.huongdanjava.systemdesign.sagapattern.stockservice.repository.mapper;

import com.huongdanjava.systemdesign.sagapattern.stockservice.domain.StockReservation;
import com.huongdanjava.systemdesign.sagapattern.stockservice.domain.StockReservationItem;
import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.entity.StockReservationEntity;
import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.entity.StockReservationItemEntity;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StockReservationRepositoryMapper {

  StockReservationEntity toEntity(StockReservation stockReservation);

  StockReservation toStockReservation(StockReservationEntity saved);

  StockReservationItemEntity toStockReservationItemEntity(
      StockReservationItem stockReservationItem);

  List<StockReservationItemEntity> toStockReservationItemEntities(List<StockReservationItem> items);

  List<StockReservationItem> toStockReservationItems(List<StockReservationItemEntity> items);

  @AfterMapping
  default void setReservation(@MappingTarget StockReservationEntity reservation) {
    if (reservation.getItems() != null) {
      reservation.getItems().forEach(item -> item.setReservation(reservation));
    }
  }
}
