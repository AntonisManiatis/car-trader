package com.github.cartrader.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@ConfigurationProperties("cartrader")
public final class CarTraderProperties {
	private final String loginUrl;
	
	@ConstructorBinding
	public CarTraderProperties(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}
}
