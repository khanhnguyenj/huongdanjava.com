package com.huongdanjava.springjdbctransactionmanagement.dao;

import java.math.BigDecimal;

public interface AccountDAO {

    BigDecimal getCurrentAmount(int id);

    void updateAmount(int id, BigDecimal amount);
}
