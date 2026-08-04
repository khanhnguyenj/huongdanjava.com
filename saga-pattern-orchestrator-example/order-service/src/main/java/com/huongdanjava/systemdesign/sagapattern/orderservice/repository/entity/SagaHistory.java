package com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
public class SagaHistory {
  @Id
  private Long id;

  private Long sagaId;

  private String step;

  private String status;

  private LocalDateTime createdAt;
}
