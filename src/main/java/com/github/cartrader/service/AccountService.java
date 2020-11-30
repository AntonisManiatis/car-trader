package com.github.cartrader.service;

import java.util.Optional;

import com.github.cartrader.entity.Account;

public interface AccountService {
	Optional<Account> findByEmail(String email);
	
	boolean exists(String email);
	
	Account create(Account account);
}
