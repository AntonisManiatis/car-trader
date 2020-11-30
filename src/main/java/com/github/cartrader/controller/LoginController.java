package com.github.cartrader.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.github.cartrader.entity.Account;
import com.github.cartrader.model.SignupForm;
import com.github.cartrader.service.AccountService;

@Controller
public class LoginController {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(LoginController.class);
	
	private final AccountService accountService;
	
	@Autowired
	public LoginController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PostMapping("/signup")
	public RedirectView signup(@Valid SignupForm signupForm, BindingResult result, 
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			LOGGER.debug("Here's the errors gathered by the BindingResult: {}", result.getAllErrors());
			// Due to the nature of our sign up page and the fact that it doesn't have a unique path
			// we need to redirect and so the bindingResult gets lost because so we have to carry it to the next request
			// https://stackoverflow.com/questions/2543797/spring-redirect-after-post-even-with-validation-errors/23749112
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.signupForm", result);
			redirectAttributes.addFlashAttribute("signupForm", signupForm);
			return new RedirectView("/");
		}
		
		accountService.create(new Account(signupForm.getEmail(), signupForm.getPassword()));
		redirectAttributes.addFlashAttribute("success", "Registration was successful!");
		// TODO: redirect to account settings or the browsing page?
		// Also upon successful registration automatically login the user IF we don't use email verification.
		return new RedirectView("/");
	}
}
