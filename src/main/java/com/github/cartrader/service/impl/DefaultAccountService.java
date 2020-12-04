package com.github.cartrader.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.cartrader.entity.Account;
import com.github.cartrader.repository.AccountRepository;
import com.github.cartrader.service.AccountService;

@Service
public final class DefaultAccountService implements AccountService {
	private final AccountRepository accountRepository;
	private final PasswordEncoder encoder;
	
	@Autowired
	public DefaultAccountService(AccountRepository accountRepository, 
			PasswordEncoder encoder) {
		this.accountRepository = accountRepository;
		this.encoder = encoder;
	}
	
	@Override
	public Optional<Account> findByEmail(String email) {
		return accountRepository.findById(email);
	}
	
	@Override
	public boolean exists(String email) {
		return accountRepository.existsById(email);
	}
	
	@Override
	public Account create(Account account) {
		account.setPasssword(encoder.encode(account.getPasssword()));
		return accountRepository.save(account);
	}
	
	@Override
	public void deleteByEmail(String email) {
		this.accountRepository.deleteById(email);
	}
}
