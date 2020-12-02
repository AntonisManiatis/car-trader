package com.github.cartrader.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.cartrader.entity.Account;
import com.github.cartrader.entity.Trader;
import com.github.cartrader.service.AccountService;

@Service
public final class DefaultUserDetailsService implements UserDetailsService {
	private final AccountService accountService;
	
	@Autowired
	public DefaultUserDetailsService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var account = accountService.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Account with email " + username + " was not found."));
		
		return new AccountUserDetails(account);
	}
	
	public class AccountUserDetails extends User {
		private final Trader trader;
		
		public AccountUserDetails(Account account) {
			// As of right now we don't require any roles so everyone is a ROLE_USER
			super(account.getEmail(), account.getPasssword(), Set.of(new SimpleGrantedAuthority("ROLE_USER")));
			
			this.trader = account.getTrader();
		}
		
		public Trader getTrader() {
			return trader;
		}
	}
}
