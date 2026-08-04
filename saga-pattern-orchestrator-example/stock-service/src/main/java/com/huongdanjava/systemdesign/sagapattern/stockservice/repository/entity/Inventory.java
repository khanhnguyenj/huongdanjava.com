package com.huongdanjava.systemdesign.sagapattern.stockservice.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Inventory {
  @Id
  private Long id;

  private String productId;
  private String quantity;
}


