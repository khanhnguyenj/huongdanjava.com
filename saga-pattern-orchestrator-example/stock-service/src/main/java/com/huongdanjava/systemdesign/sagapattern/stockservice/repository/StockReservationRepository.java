package com.huongdanjava.systemdesign.sagapattern.stockservice.repository;

import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.entity.StockReservationEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockReservationRepository extends JpaRepository<StockReservationEntity, Long> {

  Optional<StockReservationEntity> findBySagaId(UUID sagaId);
}
