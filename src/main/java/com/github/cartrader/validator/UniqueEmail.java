package com.github.cartrader.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Checks if the given Email is not already in use.
 * @author Anthony
 */
@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
	
    String message() default "Email is already taken by another user";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
