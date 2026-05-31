package com.huongdanjava.springboot.seata.accountservice.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class AccountEntity {

  @Id
  private Long id;

  @Column
  private String userId;

  @Column
  private BigDecimal balance;
}
