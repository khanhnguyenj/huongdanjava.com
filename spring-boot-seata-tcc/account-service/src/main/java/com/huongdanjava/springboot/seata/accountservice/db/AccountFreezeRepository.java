package com.huongdanjava.springboot.seata.accountservice.db;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountFreezeRepository extends JpaRepository<AccountFreezeEntity, Long> {

  List<AccountFreezeEntity> findByXidAndUserId(String xid, String userId);
}
