package com.github.cartrader.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.github.cartrader.configuration.CurrentTrader;
import com.github.cartrader.entity.Trader;
import com.github.cartrader.model.TraderDetails;
import com.github.cartrader.service.AccountService;

/**
 * 
 * @author Anthony
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(AccountController.class);
	
	private final AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping
	public String myAccount(@CurrentTrader Trader trader, 
			TraderDetails traderDetails) {
		traderDetails.setFirstName(trader.getFirstName());
		traderDetails.setLastName(trader.getLastname());
		return "account";
	}
	
	@PostMapping
	public ModelAndView saveChanges(@CurrentTrader Trader trader, 
			@Valid TraderDetails traderDetails, BindingResult result) {
		var mov = new ModelAndView("account");
		if (result.hasErrors()) {
			return mov;
		}
		
		trader.setFirstName(traderDetails.getFirstName());
		trader.setLastname(traderDetails.getLastName());
		mov.addObject("infoSaved", "infoSaved");
		return mov;
	}
	
	@PostMapping("/delete")
	public RedirectView deleteAccount(Principal principal, HttpServletRequest request) {
		// Principal actually contains the email that the user logged in with.
		accountService.deleteByEmail(principal.getName());
		// This logs out the current user.
		new SecurityContextLogoutHandler().logout(request, null, null);
		
		return new RedirectView("/");
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
