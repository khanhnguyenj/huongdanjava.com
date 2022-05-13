package com.huongdanjava.springdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huongdanjava.springdatajpa.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
