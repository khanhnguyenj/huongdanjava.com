package com.huongdanjava.systemdesign;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Outbox {

  @Id
  private UUID id;
  private UUID aggregateId;
  private String type;
  private String eventType;
  private String payload;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getAggregateId() {
    return aggregateId;
  }

  public void setAggregateId(UUID aggregateId) {
    this.aggregateId = aggregateId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }
}
