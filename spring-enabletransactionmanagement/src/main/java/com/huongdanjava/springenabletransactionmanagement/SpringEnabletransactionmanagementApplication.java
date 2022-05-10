package com.huongdanjava.springenabletransactionmanagement;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
// @EnableTransactionManagement
@EnableJpaRepositories
public class SpringEnabletransactionmanagementApplication implements CommandLineRunner {

  @Autowired
  private AccountRepository accountRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringEnabletransactionmanagementApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub

  }

  @Transactional(rollbackFor = Exception.class)
  public void transfer(int sourceId, int destId, BigDecimal amount) throws Exception {
    Account sourceAccount = accountRepository.findById(sourceId).get();
    BigDecimal sourceAmount = sourceAccount.getAmount();

    Account destAccount = accountRepository.findById(destId).get();
    BigDecimal destAmount = destAccount.getAmount();

    // Update source account
    sourceAccount.setAmount(sourceAmount.subtract(amount));
    accountRepository.save(sourceAccount);

    // Update dest account
    destAccount.setAmount(destAmount.add(amount));
    accountRepository.save(destAccount);
  }

}
