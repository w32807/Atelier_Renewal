package com.atelier.main.login.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		log.info("authenticate 실행 됩니다");
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		
		String username = token.getName();
		String password = (String) token.getCredentials();
		
		//UserResponseDto userResponseDto = (UserDetailsService) userDetailsService.loadUserByUsername(username);
		if(!passwordEncoder.matches(password, "userResponseDto.getPassword()")) {
			//throw new BadCredentialsException(userResponseDto.getUsername() + "비밀번호가 일치하지 않습니다.");
		}
		//return new UsernamePasswordAuthenticationToken(userDetailsVO, userPw, userDetailsVO.getAuthorities());
		return null;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
