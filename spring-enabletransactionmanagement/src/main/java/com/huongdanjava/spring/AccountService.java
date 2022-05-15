package com.huongdanjava.spring;

import java.math.BigDecimal;

public interface AccountService {

  void transfer(int sourceId, int destId, BigDecimal amount) throws Exception;
}
