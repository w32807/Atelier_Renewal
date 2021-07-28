package com.atelier.main.login.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.atelier.dto.responseDto.UserResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		String password = (String) token.getCredentials();
		
		// 사용자에게 입력받은 id로 DB에서 사용자 정보를 조회함
		UserResponseDto userResponseDto = (UserResponseDto) userDetailsService.loadUserByUsername(token.getName());
		
		// 입력받은 이메일로 저장된 사용자 데이터가 있지만 비밀번호가 일치하지 않는다면 LoginFailureHandler로 이동
		if(!passwordEncoder.matches(password, userResponseDto.getPassword())) {
			throw new BadCredentialsException(userResponseDto.getUsername() + "비밀번호가 일치하지 않습니다.");
		}
		return new UsernamePasswordAuthenticationToken(userResponseDto, password, userResponseDto.getAuthorities());
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
