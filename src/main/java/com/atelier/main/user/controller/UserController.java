package com.atelier.main.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atelier.dto.requestDto.UserRequestDto;
import com.atelier.dto.responseDto.UserResponseDto;
import com.atelier.entity.UserEntity;
import com.atelier.main.user.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SessionAttributes("user")
public class UserController {
	
	private final UserService service;

	//회원가입창 출력
	@RequestMapping(value = "/memJoinFrm", method = RequestMethod.GET)
	public String memJoinFrm(Model model) {
		model.addAttribute("user", new UserRequestDto());
		return "/main/memJoinFrm.mainTiles";
	}
	
	@PostMapping("emailDplChk")
	@ResponseBody
	public int emailDplChk(String email) {
		return service.emailDplChk(email);
	}
	
	@PostMapping("nickNameDplChk")
	@ResponseBody
	public int nickNameDplChk(String nickName) {
		return service.nickNameDplChk(nickName);
	}
}
