package com.atelier.main.login.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.atelier.dto.responseDto.UserResponseDto;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserResponseDto userResponseDto = (UserResponseDto) authentication.getPrincipal(); // 토큰으로 인증 된 유저 객체를 가져온다.
		String userId = userResponseDto.getCmEmail();
		
		if("on".equals(request.getParameter("saveId"))) {
			Cookie cookie = new Cookie("username", userId);
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath("/login"); // 설정한 경로의 하위 경로일 때만 쿠키를 전송함 (=하위경로일 때만 쿠키 사용함)
			response.addCookie(cookie);
		}
		// 세션값은 컨트롤러에 매번 전달해주는 로직을 구현하지 않아도 model에 기본으로 담겨서 전달된다.
		session.setAttribute("userId", userId);
		session.setAttribute("userName", userResponseDto.getCmName());
		session.setAttribute("userNick", userResponseDto.getCmNick());
		response.sendRedirect("/loginProc"); 
	}
}
