package com.github.cartrader.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.cartrader.service.AccountService;

/**
 * A {@link ConstraintValidator} that checks if the Email provided is already used by another user.
 * @author Anthony
 */
@Component
public final class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	private final AccountService accountService;
	
	@Autowired
	public UniqueEmailValidator(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return !accountService.exists(email);
	}
}
