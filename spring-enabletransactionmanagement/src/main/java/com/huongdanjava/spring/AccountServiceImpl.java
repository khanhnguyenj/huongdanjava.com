package com.huongdanjava.spring;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountDAO accountDAO;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void transfer(int sourceId, int destId, BigDecimal amount) throws Exception {
    BigDecimal sourceAmount = accountDAO.getCurrentAmount(sourceId);
    BigDecimal destAmount = accountDAO.getCurrentAmount(destId);

    // Update source account
    BigDecimal subtractAmount = sourceAmount.subtract(amount);
    accountDAO.updateAmount(sourceId, subtractAmount);
    if (subtractAmount.compareTo(BigDecimal.valueOf(80)) <= 0) {
      throw new Exception("Not allow send money if current amount is less than 80$");
    }

    // Update dest account
    accountDAO.updateAmount(destId, destAmount.add(amount));
  }
}
