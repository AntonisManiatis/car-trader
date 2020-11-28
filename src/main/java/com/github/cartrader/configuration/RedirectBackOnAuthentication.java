package com.github.cartrader.configuration;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Redirects back to the page
 * @author Anthony
 */
public final class RedirectBackOnAuthentication implements AuthenticationFailureHandler,
	AuthenticationSuccessHandler {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(RedirectBackOnAuthentication.class);
	
	private static final String DEFAULT_FAILURE_URL = "?error";
	
	private final RedirectStrategy redirectStrategy;
	private final String failureUrl;
	
	public RedirectBackOnAuthentication(RedirectStrategy redirectStrategy, String failureUrl) {
		this.redirectStrategy = redirectStrategy;
		this.failureUrl = failureUrl;
	}
	
	public RedirectBackOnAuthentication(String failureUrl) {
		this(new DefaultRedirectStrategy(), failureUrl);
	}
	
	public RedirectBackOnAuthentication() {
		this(new DefaultRedirectStrategy(), DEFAULT_FAILURE_URL);
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {		
	    if (response.isCommitted()) {
	        return;
	    }
	    
	    var referer = request.getHeader("referer");
	    
	    try {
			var uri = new URI(referer);
			LOGGER.debug("Referer {}, and URI path {}", referer, uri.getPath());
		    redirectStrategy.sendRedirect(request, response, uri.getPath());
		} catch (URISyntaxException e) {
			LOGGER.warn("{}", e);
		}
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
	    if (response.isCommitted()) {
	        return;
	    }
	    
	    var referer = request.getHeader("referer");
	    
	    try {
			var uri = new URI(referer);
			LOGGER.debug("Referer {}, and URI path {}", referer, uri.getPath());
		    redirectStrategy.sendRedirect(request, response, uri.getPath() + failureUrl);
		} catch (URISyntaxException e) {
			LOGGER.warn("{}", e);
		}
	}
}
