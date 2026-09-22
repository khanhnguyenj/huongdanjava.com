package com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductEntity {

  @Id private Long id;

  private String name;

  private BigDecimal price;

  private String currency;
}
