package com.github.cartrader.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder encoder;
	
	@Value("${cartrader.loginUrl}")
	private String loginUrl;
	
	@Autowired
	public SecurityConfiguration(UserDetailsService userDetailsService, 
			PasswordEncoder encoder) {
		this.userDetailsService = userDetailsService;
		this.encoder = encoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		var handler = handler();
		
		http
			.authorizeRequests()
				.antMatchers("/", "/ads", "/ads/search").permitAll()
				.antMatchers(HttpMethod.POST, "/ads/submit").authenticated()
				.antMatchers("/account/**").authenticated()
				.and()
			.formLogin()
				.loginPage(loginUrl)
				.failureHandler(handler)
				.successHandler(handler)
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/")
				.permitAll();
	}
	
	@Bean
	public RedirectBackOnAuthentication handler() {
		return new RedirectBackOnAuthentication();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(encoder);
	}
}
