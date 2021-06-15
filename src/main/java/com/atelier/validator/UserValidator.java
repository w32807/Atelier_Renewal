package com.atelier.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.atelier.dto.requestDto.UserRequestDto;
import com.atelier.main.user.service.UserService;

import lombok.AllArgsConstructor;

import com.atelier.util.ValidUtils;
import com.google.common.base.Strings;
@Component
@AllArgsConstructor
public class UserValidator implements Validator{
	
	private final UserService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// instanceof : 특정 Object가 상속, 구현받았는지 확인
		// isAssignableFrom : 특정 Class가 상속, 구현받았는지 확인 (그래서 .class.isAssignableFrom 가 된다)
		return (UserRequestDto.class.isAssignableFrom(clazz));
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		UserRequestDto userRequestDto = (UserRequestDto) target;
		
		// 1. Email 체크
		//  정규식 체크
		//  중복체크
		Strings.nullToEmpty(userRequestDto.getCmEmail());
		
		// 2. password 체크
		// 정규식 체크
		// 다시 입력 일치여부체크
		
		// 3. 이름체크
		// 정규식체크
		
		// 4. 닉네임체크
		// 중복체크
		
		// 5. 전화번호체크
		// 정규식체크
		
		// 6. 체크여부 체크
	}
	
	private void emailValidChk(String email) {
		
	}
}
