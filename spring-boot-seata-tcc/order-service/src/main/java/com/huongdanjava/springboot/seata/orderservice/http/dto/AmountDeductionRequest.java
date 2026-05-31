package com.huongdanjava.springboot.seata.orderservice.http.dto;

import java.math.BigDecimal;

public record AmountDeductionRequest(String userId, BigDecimal amount) {

}
