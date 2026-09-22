package com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity;

import com.huongdanjava.systemdesign.sagapattern.orderservice.saga.SagaStep;
import com.huongdanjava.systemdesign.sagapattern.orderservice.saga.SagaStepStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.Data;

@Data
@Table(name = "saga_history")
@Entity
public class SagaHistoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private UUID sagaId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SagaStep step;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SagaStepStatus status;

  private String message;

  @Column(nullable = false)
  private Instant createdAt;
}
