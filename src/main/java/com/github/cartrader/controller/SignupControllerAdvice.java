package com.github.cartrader.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.github.cartrader.model.SignupForm;

/**
 * A user can sign up from anywhere in the application so we need a global model attribute
 * thus we created this controller advice.
 * @author Anthony
 */
@ControllerAdvice
public class SignupControllerAdvice {
	@ModelAttribute("signupForm")
	public SignupForm form() {
		return new SignupForm();
	}
}
