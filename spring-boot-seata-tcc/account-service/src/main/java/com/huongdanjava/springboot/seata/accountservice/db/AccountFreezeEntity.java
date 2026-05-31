package com.huongdanjava.springboot.seata.accountservice.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Table(name = "account_freeze")
@Data
public class AccountFreezeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String xid;

  @Column
  private String userId;

  @Column
  private BigDecimal frozen;
}
