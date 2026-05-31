package com.huongdanjava.springboot.seata.accountservice.controller.dto;

import java.math.BigDecimal;

public record AmountDeductionRequest(String userId, BigDecimal amount) {

}
