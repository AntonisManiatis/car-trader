package com.github.cartrader.service.impl;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.cartrader.entity.Account;
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
		
		return new Adapter(account);
	}
	
	/**
	 * Adapts our {@link Account} entity to Spring's {@link UserDetails}
	 * @author Anthony
	 */
	private class Adapter implements UserDetails {
		private final Account account;
		
		public Adapter(Account account) {
			Assert.notNull(account, () -> "Account cannot be null.");
			this.account = account;
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return Set.of(new SimpleGrantedAuthority("ROLE_USER"));
		}

		@Override
		public String getPassword() {
			return account.getPasssword();
		}

		@Override
		public String getUsername() {
			return account.getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}	
	}
}
