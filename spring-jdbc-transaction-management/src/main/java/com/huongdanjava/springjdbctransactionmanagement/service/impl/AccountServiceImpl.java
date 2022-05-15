package com.huongdanjava.springjdbctransactionmanagement.service.impl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huongdanjava.springjdbctransactionmanagement.dao.AccountDAO;
import com.huongdanjava.springjdbctransactionmanagement.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountDAO accountDAO;

  @Transactional(rollbackFor = Exception.class)
  public void transfer(int sourceId, int destId, BigDecimal amount) throws Exception {
    BigDecimal sourceAmount = accountDAO.getCurrentAmount(sourceId);
    BigDecimal destAmount = accountDAO.getCurrentAmount(destId);

    // Update source account
    BigDecimal subtract = sourceAmount.subtract(amount);
    accountDAO.updateAmount(sourceId, subtract);
    if (subtract.compareTo(BigDecimal.valueOf(20)) <= 0) {
      throw new Exception("Not allow send money if current amount is less than 20$");
    }

    // Update dest account
    accountDAO.updateAmount(destId, destAmount.add(amount));
  }
}
