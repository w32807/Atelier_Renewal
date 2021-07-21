package com.atelier.main.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
}
