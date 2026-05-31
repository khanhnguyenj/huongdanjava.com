package com.huongdanjava.springboot.seata.accountservice.controller;

import com.huongdanjava.springboot.seata.accountservice.controller.dto.AmountDeductionRequest;
import com.huongdanjava.springboot.seata.accountservice.service.AccountTccService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

  private AccountTccService accountTccService;

  @PostMapping("/prepare-deduct")
  void deduct(@RequestBody AmountDeductionRequest amountDeductionRequest) {
    accountTccService.prepareDeduct(null, amountDeductionRequest.userId(),
        amountDeductionRequest.amount());
  }
}
