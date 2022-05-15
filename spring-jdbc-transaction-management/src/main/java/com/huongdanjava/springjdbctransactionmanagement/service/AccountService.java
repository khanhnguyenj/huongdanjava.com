package com.huongdanjava.springjdbctransactionmanagement.service;

import java.math.BigDecimal;

public interface AccountService {

  void transfer(int sourceId, int destId, BigDecimal amount) throws Exception;
}
