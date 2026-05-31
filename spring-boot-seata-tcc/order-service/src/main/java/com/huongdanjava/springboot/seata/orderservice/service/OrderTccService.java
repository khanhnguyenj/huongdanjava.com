package com.huongdanjava.springboot.seata.orderservice.service;

import java.math.BigDecimal;
import org.apache.seata.rm.tcc.api.BusinessActionContext;
import org.apache.seata.rm.tcc.api.LocalTCC;
import org.apache.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface OrderTccService {

  @TwoPhaseBusinessAction(name = "orderTccService", commitMethod = "confirm", rollbackMethod = "cancel")
  boolean prepareCreate(BusinessActionContext actionContext, String orderId, String userId,
      BigDecimal amount);

  boolean confirm(BusinessActionContext ctx);

  boolean cancel(BusinessActionContext ctx);
}