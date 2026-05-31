package com.huongdanjava.springboot.seata.accountservice.service;

import java.math.BigDecimal;
import org.apache.seata.rm.tcc.api.BusinessActionContext;
import org.apache.seata.rm.tcc.api.LocalTCC;
import org.apache.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface AccountTccService {

  @TwoPhaseBusinessAction(
      name = "accountTccService",
      commitMethod = "confirm",
      rollbackMethod = "cancel"
  )
  boolean prepareDeduct(BusinessActionContext ctx, String userId,
      BigDecimal amount);

  boolean confirm(BusinessActionContext ctx);

  boolean cancel(BusinessActionContext ctx);
}