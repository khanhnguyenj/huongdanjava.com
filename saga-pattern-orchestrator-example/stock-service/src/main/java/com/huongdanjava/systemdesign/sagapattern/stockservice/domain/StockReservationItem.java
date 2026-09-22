package com.huongdanjava.systemdesign.sagapattern.stockservice.domain;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Data;

@Data
public class StockReservationItem {
  private Integer productId;
  private Integer quantity;
}
