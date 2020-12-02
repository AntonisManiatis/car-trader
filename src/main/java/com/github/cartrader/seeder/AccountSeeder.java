package com.github.cartrader.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.cartrader.entity.Account;
import com.github.cartrader.service.AccountService;

@Component
@Profile("dev")
public final class AccountSeeder implements CommandLineRunner {
	private final AccountService accountService;
	
	@Autowired
	public AccountSeeder(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.accountService.create(new Account("arandomemail@gmail.com", "12345678"));
	}
}
