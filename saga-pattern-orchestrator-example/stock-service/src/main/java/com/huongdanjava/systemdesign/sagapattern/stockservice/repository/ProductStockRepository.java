package com.huongdanjava.systemdesign.sagapattern.stockservice.repository;

import com.huongdanjava.systemdesign.sagapattern.stockservice.repository.entity.ProductStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStockEntity, Long> {}
