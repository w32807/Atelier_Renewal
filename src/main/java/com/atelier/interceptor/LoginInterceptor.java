package com.atelier.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// Return 값이 True이면 정상 진행, false일 경우 컨트롤러 진입을 안함
		System.out.println("preHandle 실행됩니다.");
		// 권한별로 세션을 체크하여, 세션이 유효하지 않으면 로그인 페이지로 이동시키기 
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
