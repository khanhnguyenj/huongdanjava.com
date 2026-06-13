package com.huongdanjava.systemdesign.outboxpattern.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Outbox {

  @Id
  private UUID id;
  private UUID aggregateId;
  private String type;
  private String eventType;
  private String payload;
}
