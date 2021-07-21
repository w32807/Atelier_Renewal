package com.atelier.main.login.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		log.info("onAuthenticationSuccess 실행됩니다");
		// 로그인 성공 시 세션에 저장, 체크박스 받아서 Cookie에 저장
		
		response.sendRedirect("/"); // 로그인 성공 시 메인화면으로 이동
	}
}
