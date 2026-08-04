package com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class SagaInstance {

  @Id private Long id;

  private String status;

  private String currentStep;

  private LocalDateTime startedAt;

  private LocalDateTime completedAt;
}
