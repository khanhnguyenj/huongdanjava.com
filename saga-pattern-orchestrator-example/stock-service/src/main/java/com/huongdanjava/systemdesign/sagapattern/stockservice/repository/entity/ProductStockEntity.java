package com.huongdanjava.systemdesign.sagapattern.stockservice.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.Instant;
import lombok.Data;

@Entity
@Table(name = "product_stock")
@Data
public class ProductStockEntity {

  @Id private Long productId;

  @Column(nullable = false)
  private Integer availableQuantity;

  @Column(nullable = false)
  private Integer reservedQuantity;

  @Column(nullable = false)
  private Instant updatedAt;

  @Version
  @Column(nullable = false)
  private Integer version;
}
