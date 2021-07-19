package com.atelier.main.user.service;

import com.atelier.dto.requestDto.UserRequestDto;

public interface UserService {

	int emailDplChk(String email);

	int nickNameDplChk(String nickName);

	String save(UserRequestDto dto);
}
