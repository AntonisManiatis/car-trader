package com.github.cartrader.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.cartrader.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

}
