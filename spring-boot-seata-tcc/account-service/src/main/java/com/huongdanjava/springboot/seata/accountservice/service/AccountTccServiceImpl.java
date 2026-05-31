package com.huongdanjava.springboot.seata.accountservice.service;

import com.huongdanjava.springboot.seata.accountservice.db.AccountEntity;
import com.huongdanjava.springboot.seata.accountservice.db.AccountFreezeEntity;
import com.huongdanjava.springboot.seata.accountservice.db.AccountFreezeRepository;
import com.huongdanjava.springboot.seata.accountservice.db.AccountRepository;
import com.huongdanjava.springboot.seata.accountservice.exception.NotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.apache.seata.rm.tcc.api.BusinessActionContext;
import org.apache.seata.rm.tcc.api.BusinessActionContextParameter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountTccServiceImpl implements AccountTccService {

  private AccountRepository accountRepository;
  private AccountFreezeRepository accountFreezeRepository;

  @Override
  public boolean prepareDeduct(BusinessActionContext ctx,
      @BusinessActionContextParameter(paramName = "userId") String userId,
      @BusinessActionContextParameter(paramName = "amount") BigDecimal amount) {
    String xid = ctx.getXid();
    if (getAccountFreeze(xid, userId).isPresent()) {
      return true;
    }

    AccountEntity account = getAccount(userId);

    if (account.getBalance().compareTo(amount) < 0) {
      throw new IllegalStateException("Insufficient funds!");
    }

    BigDecimal subtract = account.getBalance().subtract(amount);
    account.setBalance(subtract);
    accountRepository.save(account);

    AccountFreezeEntity accountFreezeEntity = new AccountFreezeEntity();
    accountFreezeEntity.setXid(xid);
    accountFreezeEntity.setUserId(userId);
    accountFreezeEntity.setFrozen(amount);
    accountFreezeRepository.save(accountFreezeEntity);

    return true;
  }

  private Optional<AccountFreezeEntity> getAccountFreeze(String xid, String userId) {
    List<AccountFreezeEntity> accountFreezes = accountFreezeRepository.findByXidAndUserId(xid,
        userId);

    if (accountFreezes.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(accountFreezes.getFirst());
  }

  private AccountEntity getAccount(String userId) {
    List<AccountEntity> accounts = accountRepository.findByUserId(userId);
    if (accounts.isEmpty()) {
      throw new NotFoundException("Account not found!");
    }

    if (accounts.size() > 1) {
      throw new IllegalStateException("More than one account exists!");
    }

    return accounts.getFirst();
  }

  @Override
  public boolean confirm(BusinessActionContext ctx) {
    String xid = ctx.getXid();
    String userid = (String) ctx.getActionContext("userId");
    getAccountFreeze(xid, userid).ifPresent(accountFreeze -> {
      accountFreezeRepository.delete(accountFreeze);
    });

    return true;
  }

  @Override
  public boolean cancel(BusinessActionContext ctx) {
    String xid = ctx.getXid();
    String userId = (String) ctx.getActionContext("userId");
    BigDecimal amount = (BigDecimal) ctx.getActionContext("amount");

    Optional<AccountFreezeEntity> accountFreeze = getAccountFreeze(xid, userId);
    if (accountFreeze.isEmpty()) {
      return true;
    }

    AccountEntity account = getAccount(userId);
    account.setBalance(account.getBalance().add(amount));
    accountRepository.save(account);

    accountFreezeRepository.delete(accountFreeze.get());

    return true;
  }
}
