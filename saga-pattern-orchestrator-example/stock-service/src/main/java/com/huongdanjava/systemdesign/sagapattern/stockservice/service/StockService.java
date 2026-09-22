package com.huongdanjava.systemdesign.sagapattern.stockservice.service;

import com.huongdanjava.systemdesign.sagapattern.stockservice.domain.ReservationStatus;
import com.huongdanjava.systemdesign.sagapattern.stockservice.domain.StockReservation;
import com.huongdanjava.systemdesign.sagapattern.stockservice.exception.InsufficientStockException;
import com.huongdanjava.systemdesign.sagapattern.stockservice.exception.ProductStockNotFoundException;
import com.huongdanjava.systemdesign.sagapattern.stockservice.exception.StockReservationNotFoundException;
import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.ProductStockRepository;
import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.StockReservationRepository;
import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.entity.ProductStockEntity;
import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.entity.StockReservationEntity;
import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.entity.StockReservationItemEntity;
import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.mapper.StockReservationRepositoryMapper;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class StockService {

  private final StockReservationRepository stockReservationRepository;

  private final ProductStockRepository productStockRepository;

  private final StockReservationRepositoryMapper stockReservationMapper;

  @Transactional
  public StockReservation reserve(StockReservation stockReservation) {
    StockReservationEntity stockReservationEntity =
        stockReservationMapper.toEntity(stockReservation);

    for (StockReservationItemEntity item : stockReservationEntity.getItems()) {
      ProductStockEntity stock =
          productStockRepository
              .findById(item.getProductId())
              .orElseThrow(
                  () ->
                      new ProductStockNotFoundException(
                          "Product stock not found: " + item.getProductId()));

      if (stock.getAvailableQuantity() < item.getQuantity()) {
        throw new InsufficientStockException(
            "Insufficient stock for product: " + item.getProductId());
      }

      stock.setAvailableQuantity(stock.getAvailableQuantity() - item.getQuantity());
      stock.setReservedQuantity(stock.getReservedQuantity() + item.getQuantity());
      stock.setUpdatedAt(Instant.now());
    }

    stockReservationEntity.setStatus(ReservationStatus.RESERVED);
    stockReservationEntity.setCreatedAt(Instant.now());
    stockReservationEntity.setUpdatedAt(Instant.now());

    StockReservationEntity saved = stockReservationRepository.save(stockReservationEntity);

    StockReservation saveStockReservation = stockReservationMapper.toStockReservation(saved);
    log.debug("Saved stock reservation {}", saveStockReservation);

    return saveStockReservation;
  }

  @Transactional
  public StockReservation release(UUID sagaId) {
    StockReservationEntity entity =
        stockReservationRepository
            .findBySagaId(sagaId)
            .orElseThrow(
                () ->
                    new StockReservationNotFoundException(
                        "Stock reservation not found for saga: " + sagaId));

    if (entity.getStatus() == ReservationStatus.RELEASED) {
      log.debug("Stock reservation already released. sagaId={}", sagaId);

      return stockReservationMapper.toStockReservation(entity);
    }

    for (StockReservationItemEntity item : entity.getItems()) {
      ProductStockEntity stock =
          productStockRepository
              .findById(item.getProductId())
              .orElseThrow(
                  () ->
                      new ProductStockNotFoundException(
                          "Product stock not found: " + item.getProductId()));

      stock.setAvailableQuantity(stock.getAvailableQuantity() + item.getQuantity());
      stock.setReservedQuantity(stock.getReservedQuantity() - item.getQuantity());
      stock.setUpdatedAt(Instant.now());
    }

    entity.setStatus(ReservationStatus.RELEASED);
    entity.setUpdatedAt(Instant.now());

    StockReservationEntity saved = stockReservationRepository.save(entity);

    return stockReservationMapper.toStockReservation(saved);
  }
}
