package com.huongdanjava.systemdesign.sagapattern.stockservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class StockReservation {
  private Long id;

  private UUID sagaId;

  private UUID orderNumber;

  private ReservationStatus status;

  List<StockReservationItem> items = new ArrayList<>();
}
