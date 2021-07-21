package com.atelier.main.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atelier.dto.requestDto.UserRequestDto;
import com.atelier.main.user.service.UserService;
import com.atelier.validator.UserValidator;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;
	private final UserValidator userValidator;

	//회원가입창 출력
	@RequestMapping(value = "/memJoinFrm", method = RequestMethod.GET)
	public String memJoinFrm(Model model) {
		//model.addAttribute("userVo", new UserVo());
		model.addAttribute("userRequestDto", new UserRequestDto());
		return "/main/memJoinFrm.mainTiles";
	}
	
	@PostMapping("/emailDplChk")
	@ResponseBody
	public int emailDplChk(String email) {
		return service.emailDplChk(email);
	}
	
	@PostMapping("/nickNameDplChk")
	@ResponseBody
	public int nickNameDplChk(String nickName) {
		return service.nickNameDplChk(nickName);
	}
	
	/* ---------------------------------------------------------------------------------------
	 * 기능: 회원 가입 컨트롤러
	 * 작성자: JSH
	 * 작성일: 2020.02.04
	 -----------------------------------------------------------------------------------------*/
	@PostMapping("/memberInsert")
	public String memberInsert(@ModelAttribute("userRequestDto") UserRequestDto userRequestDto, BindingResult bindingResult, Model model) {
		this.userValidator.validate(userRequestDto, bindingResult);
		if(bindingResult.hasErrors()) return "/main/memJoinFrm.mainTiles";
		service.save(userRequestDto);
		return "/main/memJoinFrm.mainTiles";
	}
}
