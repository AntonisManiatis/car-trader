package com.github.cartrader.configuration;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.github.cartrader.entity.Trader;

/**
 * The currently authenticated {@link Trader} and {@code null} if the user is not authenticated.
 * @author Anthony
 * @see org.springframework.security.core.annotation.AuthenticationPrincipal
 */
@Target({PARAMETER, TYPE})
@Retention(RUNTIME)
@Documented
@AuthenticationPrincipal(expression = "trader")
public @interface CurrentTrader {

}
