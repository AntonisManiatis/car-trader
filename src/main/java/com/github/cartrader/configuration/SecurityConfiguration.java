package com.github.cartrader.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final RedirectBackOnAuthentication handler = new RedirectBackOnAuthentication();
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/ads", "/ads/search").permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.failureHandler(handler)
				.successHandler(handler)
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/")
				.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Not_Reflections").password("{noop}1234").roles("USER");
	}
}
