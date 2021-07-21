package com.atelier.main.login.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import lombok.extern.log4j.Log4j;

public class LoginFailureHandler implements AuthenticationFailureHandler{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,	AuthenticationException exception) throws IOException, ServletException {
		request.setAttribute("msg", "이메일 혹은 비밀번호를 확인 해 주세요");
		request.getRequestDispatcher("/loginFail").forward(request, response);
	}
}
