package com.atelier.main.login.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		
		if("on".equals(request.getParameter("saveId"))) {
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath("/login"); // 설정한 경로의 하위 경로일 때만 쿠키를 전송함 (=하위경로일 때만 쿠키 사용함)
			response.addCookie(cookie);
		}
		session.setAttribute("userId", username);
		response.sendRedirect("/loginProc"); 
	}
}
