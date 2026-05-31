package com.huongdanjava.springboot.seata.accountservice.db;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

  List<AccountEntity> findByUserId(String userId);
}
