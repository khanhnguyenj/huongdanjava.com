package com.huongdanjava.systemdesign.sagapattern.orderservice.saga;

import com.huongdanjava.systemdesign.sagapattern.orderservice.client.PaymentClient;
import com.huongdanjava.systemdesign.sagapattern.orderservice.client.StockClient;
import com.huongdanjava.systemdesign.sagapattern.orderservice.domain.Order;
import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.OrderRepository;
import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.SagaHistoryRepository;
import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.SagaRepository;
import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity.OrderEntity;
import com.huongdanjava.systemdesign.sagapattern.orderservice.domain.OrderStatus;
import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity.SagaHistoryEntity;
import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity.SagaInstanceEntity;
import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.mapper.OrderMapper;
import com.huongdanjava.systemdesign.sagapattern.web.dto.PaymentRequest;
import com.huongdanjava.systemdesign.sagapattern.web.dto.PaymentResponse;
import com.huongdanjava.systemdesign.sagapattern.web.dto.StockItemDto;
import com.huongdanjava.systemdesign.sagapattern.web.dto.StockReleaseRequest;
import com.huongdanjava.systemdesign.sagapattern.web.dto.StockReservationRequest;
import com.huongdanjava.systemdesign.sagapattern.web.dto.StockReservationResponse;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SagaOrchestrator {

  private final OrderRepository orderRepository;
  private final SagaRepository sagaRepository;
  private final SagaHistoryRepository sagaHistoryRepository;

  private final StockClient stockClient;
  private final PaymentClient paymentClient;

  private final OrderMapper orderMapper;

  public Order execute(OrderEntity order, boolean isSimulatePaymentFailure) {
    SagaInstanceEntity saga = createSaga(order.getId());

    try {
      reserveStock(saga, order);

      processPayment(saga, order, isSimulatePaymentFailure);

      return completeOrder(saga, order);
    } catch (Exception ex) {
      recordHistory(
          saga.getId(), saga.getCurrentStep(), SagaStepStatus.FAILED, "Failed: " + ex.getMessage());

      compensate(saga, order, ex);

      throw ex;
    }
  }

  private SagaInstanceEntity createSaga(Long orderId) {
    SagaInstanceEntity saga = new SagaInstanceEntity();

    saga.setId(UUID.randomUUID());
    saga.setOrderId(orderId);
    saga.setStatus(SagaStatus.STARTED);
    saga.setCurrentStep(SagaStep.RESERVE_STOCK);
    saga.setCreatedAt(Instant.now());
    saga.setUpdatedAt(Instant.now());

    SagaInstanceEntity saved = sagaRepository.save(saga);

    log.info("Saga created: sagaId={}, orderId={}", saved.getId(), saved.getOrderId());

    return saved;
  }

  private void reserveStock(SagaInstanceEntity saga, OrderEntity order) {
    log.info("Reserving stock for order={}", order);
    UUID sagaId = saga.getId();

    transition(saga, SagaStep.RESERVE_STOCK, SagaStatus.RUNNING);

    StockReservationRequest request = createStockReservationRequest(sagaId, order);
    log.debug("StockReservationRequest: {}", request);

    recordHistory(
        sagaId, SagaStep.RESERVE_STOCK, SagaStepStatus.STARTED, "Starting stock reservation");

    StockReservationResponse reserved = stockClient.reserve(request);
    log.debug("StockReservationResponse: {}", reserved);

    updateOrderStatus(order, OrderStatus.STOCK_RESERVED);

    recordHistory(
        sagaId, SagaStep.RESERVE_STOCK, SagaStepStatus.SUCCESS, "Stock reserved successfully");

    log.info("Stock reserved for orderId={}, response {}", order.getId(), reserved);
  }

  private StockReservationRequest createStockReservationRequest(UUID sagaId, OrderEntity order) {
    StockReservationRequest stockReservationRequest = new StockReservationRequest();
    stockReservationRequest.sagaId(sagaId);
    stockReservationRequest.setOrderNumber(order.getOrderNumber());

    List<StockItemDto> stockItemDtos =
        order.getItems().stream()
            .map(
                i -> {
                  StockItemDto stockItemDto = new StockItemDto();
                  stockItemDto.setProductId(i.getProductId().intValue());
                  stockItemDto.setQuantity(i.getQuantity());

                  return stockItemDto;
                })
            .toList();
    stockReservationRequest.setItems(stockItemDtos);

    return stockReservationRequest;
  }

  private void processPayment(
      SagaInstanceEntity saga, OrderEntity order, boolean isSimulatePaymentFailure) {
    transition(saga, SagaStep.PROCESS_PAYMENT, SagaStatus.RUNNING);

    UUID sagaId = saga.getId();

    PaymentRequest request = createPaymentRequest(sagaId, order, isSimulatePaymentFailure);
    log.debug("PaymentRequest {}", request);

    updateOrderStatus(order, OrderStatus.PAYMENT_PROCESSING);

    recordHistory(
        sagaId, SagaStep.PROCESS_PAYMENT, SagaStepStatus.STARTED, "Starting payment processing");

    PaymentResponse charged = paymentClient.charge(request);
    log.debug("PaymentResponse {}", charged);

    recordHistory(
        sagaId, SagaStep.PROCESS_PAYMENT, SagaStepStatus.SUCCESS, "Payment processed successfully");

    log.info("Payment processed for orderId={}, response {}", order.getId(), charged);
  }

  private PaymentRequest createPaymentRequest(
      UUID id, OrderEntity order, boolean isSimulatePaymentFailure) {
    PaymentRequest paymentRequest = new PaymentRequest();
    paymentRequest.sagaId(id.toString());
    paymentRequest.setOrderId(order.getId().intValue());
    paymentRequest.setCustomerId(order.getCustomerId().intValue());
    paymentRequest.setAmount(order.getTotalAmount());
    paymentRequest.setCurrency(order.getCurrency());
    paymentRequest.setSimulateFailure(isSimulatePaymentFailure);
    paymentRequest.setPaymentMethod(order.getPaymentMethod());

    return paymentRequest;
  }

  private Order completeOrder(SagaInstanceEntity saga, OrderEntity order) {
    updateOrderStatus(order, OrderStatus.CONFIRMED);

    saga.setCompletedAt(Instant.now());
    transition(saga, SagaStep.COMPLETE_ORDER, SagaStatus.COMPLETED);

    recordHistory(
        saga.getId(),
        SagaStep.COMPLETE_ORDER,
        SagaStepStatus.SUCCESS,
        "Order completed successfully");

    log.info("Saga completed: {}", saga.getId());

    return orderMapper.toDomain(order);
  }

  private void compensate(SagaInstanceEntity saga, OrderEntity order, Exception ex) {
    UUID sagaId = saga.getId();

    log.error("Saga failed: {}", sagaId, ex);

    transition(saga, saga.getCurrentStep(), SagaStatus.COMPENSATING);

    try {
      if (stockWasReserved(sagaId)) {
        releaseStock(saga);
      }

      cancelOrder(saga, order);

      transition(saga, saga.getCurrentStep(), SagaStatus.CANCELLED);
    } catch (Exception compensationException) {
      transition(saga, saga.getCurrentStep(), SagaStatus.FAILED);

      recordHistory(
          sagaId,
          saga.getCurrentStep(),
          SagaStepStatus.FAILED,
          "Compensation failed: " + compensationException.getMessage());

      log.error("Saga compensation failed: {}", sagaId, compensationException);
    }
  }

  private void cancelOrder(SagaInstanceEntity saga, OrderEntity order) {
    log.info("Cancelling order: orderId={}, sagaId={}", order.getId(), saga.getId());

    transition(saga, SagaStep.CANCEL_ORDER, SagaStatus.RUNNING);

    recordHistory(
        saga.getId(), SagaStep.CANCEL_ORDER, SagaStepStatus.STARTED, "Starting order cancellation");

    updateOrderStatus(order, OrderStatus.CANCELLED);

    transition(saga, SagaStep.CANCEL_ORDER, SagaStatus.CANCELLED);

    recordHistory(
        saga.getId(),
        SagaStep.CANCEL_ORDER,
        SagaStepStatus.SUCCESS,
        "Order cancelled successfully");

    log.info("Order cancelled successfully: orderId={}", order.getId());
  }

  private void releaseStock(SagaInstanceEntity saga) {
    transition(saga, SagaStep.RELEASE_STOCK, SagaStatus.RUNNING);

    recordHistory(
        saga.getId(), SagaStep.RELEASE_STOCK, SagaStepStatus.STARTED, "Starting stock release");

    StockReleaseRequest request = new StockReleaseRequest();
    request.setSagaId(saga.getId());
    stockClient.release(request);

    recordHistory(
        saga.getId(),
        SagaStep.RELEASE_STOCK,
        SagaStepStatus.SUCCESS,
        "Stock released successfully");

    log.info("Stock released for sagaId={}", saga.getId());
  }

  private void recordHistory(UUID sagaId, SagaStep step, SagaStepStatus status, String message) {
    SagaHistoryEntity history = new SagaHistoryEntity();
    history.setSagaId(sagaId);
    history.setStep(step);
    history.setStatus(status);
    history.setMessage(message);
    history.setCreatedAt(Instant.now());

    sagaHistoryRepository.save(history);
  }

  private void transition(SagaInstanceEntity saga, SagaStep step, SagaStatus status) {
    saga.setCurrentStep(step);
    saga.setStatus(status);
    saga.setUpdatedAt(Instant.now());

    sagaRepository.save(saga);
  }

  private void updateOrderStatus(OrderEntity order, OrderStatus status) {
    order.setStatus(status);
    order.setUpdatedAt(Instant.now());

    orderRepository.save(order);
  }

  private boolean stockWasReserved(UUID sagaId) {
    return sagaHistoryRepository.existsBySagaIdAndStepAndStatus(
        sagaId, SagaStep.RESERVE_STOCK, SagaStepStatus.SUCCESS);
  }
}
