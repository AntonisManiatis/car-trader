package com.github.cartrader.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.cartrader.configuration.CurrentTrader;
import com.github.cartrader.entity.Trader;

/**
 * 
 * @author Anthony
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping
	public String myAccount() {
		return "create";
	}
	
	@GetMapping("/ads")
	public ModelAndView myAds(@CurrentTrader Trader trader) {
		var mov = new ModelAndView("myads");
		
		var ads = trader.getAds();
		LOGGER.debug("Ads of the current trader: {}", ads);
		mov.addObject("ads", ads);
		return mov;
	}
}
