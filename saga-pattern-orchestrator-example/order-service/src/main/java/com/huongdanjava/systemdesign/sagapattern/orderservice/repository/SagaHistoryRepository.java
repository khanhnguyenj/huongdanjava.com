package com.huongdanjava.systemdesign.sagapattern.orderservice.repository;

import com.huongdanjava.systemdesign.sagapattern.orderservice.repository.entity.SagaHistoryEntity;
import com.huongdanjava.systemdesign.sagapattern.orderservice.saga.SagaStep;
import com.huongdanjava.systemdesign.sagapattern.orderservice.saga.SagaStepStatus;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SagaHistoryRepository extends JpaRepository<SagaHistoryEntity, Long> {
  boolean existsBySagaIdAndStepAndStatus(UUID sagaId, SagaStep step, SagaStepStatus status);
}
