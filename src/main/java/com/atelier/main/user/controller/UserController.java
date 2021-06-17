package com.atelier.main.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atelier.dto.CM_Dto;
import com.atelier.dto.requestDto.ShippingAddRequestDto;
import com.atelier.dto.requestDto.UserRequestDto;
import com.atelier.dto.responseDto.UserResponseDto;
import com.atelier.entity.UserEntity;
import com.atelier.main.user.service.UserService;
import com.atelier.validator.UserValidator;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SessionAttributes("user")
public class UserController {
	
	private final UserService service;
	private final UserValidator userValidator;

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
	
	/* ---------------------------------------------------------------------------------------
	 * 기능: 회원 가입 컨트롤러
	 * 작성자: JSH
	 * 작성일: 2020.02.04
	 -----------------------------------------------------------------------------------------*/
	@PostMapping("memberInsert")
	public String memberInsert(@ModelAttribute("user") UserRequestDto user, BindingResult bindingResult, SessionStatus status, Model model) {
		this.userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			System.out.println("에러있음");
			model.addAttribute("","");
			return "/main/memJoinFrm.mainTiles";
		}
		return "/main/memJoinFrm.mainTiles";
	}
}
