package com.huongdanjava.springboot.seata.orderservice.http;

import com.huongdanjava.springboot.seata.orderservice.http.dto.AmountDeductionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "account-service")
public interface AccountClient {

  @PostMapping("/accounts/prepare-deduct")
  void deduct(AmountDeductionRequest amountDeductionRequest);
}
