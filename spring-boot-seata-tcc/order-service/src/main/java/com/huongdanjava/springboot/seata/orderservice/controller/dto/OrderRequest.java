package com.huongdanjava.springboot.seata.orderservice.controller.dto;

import java.math.BigDecimal;

public record OrderRequest(String userId, BigDecimal amount) {

}
