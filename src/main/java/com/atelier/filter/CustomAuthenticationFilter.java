package com.atelier.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) { 
		super.setAuthenticationManager(authenticationManager); 
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		log.info("attemptAuthentication 실행 됩니다");
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(request.getParameter("username"), request.getParameter("password"));
		setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);
	}

}
