package com.github.cartrader.configuration;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${cartrader.loginUrl}")
	private String loginUrl;
	
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
			var path = uri.getPath();
			LOGGER.debug("Referer {}, and URI path {}", referer, path);
			
			/*
			 * In the case that the user has been redirected to our login page (say they hit /account url)
			 * when they successfully authenticate this handler is meant to redirect
			 * them back to the page that they were browsing (because of the modal login)
			 * but in the case that they will be redirected back to the login page because this is the page
			 * they were browsing and we don't want that so if the referer path is the login page
			 * redirect them back to the index page.
			 */
			if (path.equals(loginUrl)) {
				path = "/";
			}
			
		    redirectStrategy.sendRedirect(request, response, path);
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
