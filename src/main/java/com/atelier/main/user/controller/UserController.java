package com.atelier.main.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atelier.dto.responseDto.UserResponseDto;

@Controller
@SessionAttributes("user")
public class UserController {

	//회원가입창 출력
	@RequestMapping(value = "/memJoinFrm", method = RequestMethod.GET)
	public String memJoinFrm(Model model) {
		model.addAttribute("user", new UserResponseDto());
		return "/main/memJoinFrm.mainTiles";
	}
}
