package com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity;

import com.huongdanjava.systemdesign.sagapattern.orderservice.saga.SagaStatus;
import com.huongdanjava.systemdesign.sagapattern.orderservice.saga.SagaStep;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.Instant;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "saga_instance")
public class SagaInstanceEntity {

  @Id private UUID id;

  @Column(nullable = false, unique = true)
  private Long orderId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SagaStatus status;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SagaStep currentStep;

  @Column(nullable = false)
  private Instant createdAt;

  @Column(nullable = false)
  private Instant updatedAt;

  private Instant completedAt;

  @Version
  @Column(nullable = false)
  private Long version;
}
