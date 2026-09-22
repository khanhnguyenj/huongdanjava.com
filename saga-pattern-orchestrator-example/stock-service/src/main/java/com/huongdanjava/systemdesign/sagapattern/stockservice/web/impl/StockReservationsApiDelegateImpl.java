package com.huongdanjava.systemdesign.sagapattern.stockservice.web.impl;

import com.huongdanjava.systemdesign.sagapattern.stockservice.domain.StockReservation;
import com.huongdanjava.systemdesign.sagapattern.stockservice.service.StockService;
import com.huongdanjava.systemdesign.sagapattern.stockservice.web.StockReservationsApiDelegate;
import com.huongdanjava.systemdesign.sagapattern.stockservice.web.dto.StockReleaseRequest;
import com.huongdanjava.systemdesign.sagapattern.stockservice.web.dto.StockReservationRequest;
import com.huongdanjava.systemdesign.sagapattern.stockservice.web.dto.StockReservationResponse;
import com.huongdanjava.systemdesign.sagapattern.stockservice.web.mapper.StockReservationWebMapper;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class StockReservationsApiDelegateImpl implements StockReservationsApiDelegate {

  private StockService stockService;

  private StockReservationWebMapper stockReservationMapper;

  @Override
  public ResponseEntity<StockReservationResponse> reserveStock(
      StockReservationRequest stockReservationRequest) {
    log.info("Reserving stock for request {}", stockReservationRequest);

    StockReservation srr = stockReservationMapper.toStockReservation(stockReservationRequest);
    log.debug("StockReservation {}", stockReservationRequest);

    StockReservation stockReservation = stockService.reserve(srr);
    log.debug("StockReservation {}", stockReservation);

    StockReservationResponse reserveStockResponse =
        stockReservationMapper.toReserveStockResponse(stockReservation);
    log.info("Reserved stock with response {}", reserveStockResponse);

    return ResponseEntity.ok(reserveStockResponse);
  }

  @Override
  public ResponseEntity<Void> releaseStock(StockReleaseRequest stockReleaseRequest) {
    log.info("Releasing stock for request: {}", stockReleaseRequest);

    StockReservation released = stockService.release(stockReleaseRequest.getSagaId());

    log.info("Released stock {}", released);

    return ResponseEntity.noContent().build();
  }
}
