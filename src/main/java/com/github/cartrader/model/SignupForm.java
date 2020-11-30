package com.github.cartrader.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.github.cartrader.validator.UniqueEmail;

/**
 * 
 * @author Anthony
 */
public class SignupForm {
	@NotNull
	@Email
	@UniqueEmail
	private String email;
	
	// TODO Add better password validation support
	@NotNull
	@Size(min = 8, max = 16)
	private String password;
	@NotNull
	@Size(min = 8, max = 16)
	private String confirmPassword;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
