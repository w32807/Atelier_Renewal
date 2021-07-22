package com.atelier.main.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.common.base.Strings;

@Controller
public class LoginController {

	/* ---------------------------------------------------------------------------------------
	 * 기능: 로그인창 출력 메소드
	 * 작성자: JSG
	 * 작성일: 2020.02.04
	 -----------------------------------------------------------------------------------------*/
	@GetMapping("/login")
	public String login() {
		return "/main/login.mainTiles";
	}
	
	@PostMapping("/loginFail")
	public String loginFail(){
		return "/main/login.mainTiles";
	}
	
	@PostMapping("/loginProc")
	public String loginProc(HttpServletRequest request, HttpServletResponse response, Model model){
		String username = request.getParameter("username");

		
		if(Strings.nullToEmpty(request.getParameter("saveId")).equals("")) {
			// 쿠키 생성
		}
		
		// 세션 생성
		System.out.println("loginProc 실행 됩니다.");
		return "/main/login.mainTiles";
	}
	
}
