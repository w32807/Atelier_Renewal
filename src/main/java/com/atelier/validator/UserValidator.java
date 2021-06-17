package com.atelier.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
	// 이렇게 private로 메소드를 선언하여 errors를 받아도 errors 기록은 쌓인다.
	public void validate(Object target, Errors errors) {
		UserRequestDto userRequestDto = (UserRequestDto) target;
		try {
			// 1. Email 체크
			//  정규식 체크
			//  중복체크
			errors = emailValidChk(userRequestDto, errors);
			// 2. password 체크
			// 정규식 체크
			// 다시 입력 일치여부체크
			errors = pwdValidChk(userRequestDto, errors);
			// 3. 이름체크
			// 정규식체크
			errors = nameValidChk(userRequestDto, errors);
			// 4. 닉네임체크
			// 중복체크
			errors = nickValidChk(userRequestDto, errors);
			// 5. 전화번호체크
			// 정규식체크
			errors = phoneNumValidChk(userRequestDto, errors);
		} catch (NullPointerException e) {
			// NPE 발생시, Error 코드는 없지만 hasError = True가 된다. 그러므로 reject로 글로벌 에러를 넣어서 다른 에러메세지를 화면에 보여주자.
			// 그리고, 유효성 검사이므로 NPE도 꼭 체크하자
			System.out.println("NPE 발생");
			return;
		}
		
	}

	private Errors emailValidChk(UserRequestDto userRequestDto, Errors errors) throws NullPointerException{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cmEmail", "confirm.email");
		
		if(!ValidUtils.emailChk(userRequestDto.getCmEmail())) {
			errors.rejectValue("cmEmail","confirm.email");
			return errors;
		}
		
		if(service.emailDplChk(userRequestDto.getCmEmail()) > 0) {
			errors.rejectValue("cmEmail","duplicate.email");
			return errors;
		}
		
		return errors;
	}
	
	private Errors pwdValidChk(UserRequestDto userRequestDto, Errors errors) throws NullPointerException{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cmPwd", "confirm.pwd");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "conCmPwd", "confirm.pwd");
		
		if(!ValidUtils.pwdChk(userRequestDto.getCmPwd()) || !userRequestDto.getCmPwd().equals(userRequestDto.getConCmPwd())) {
			errors.rejectValue("cmPwd","confirm.pwd");
			return errors;
		}
		
		return errors;
	}
	
	private Errors nameValidChk(UserRequestDto userRequestDto, Errors errors) throws NullPointerException{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cmName", "confirm.name");
		
		if(!ValidUtils.nameChk(userRequestDto.getCmName())) {
			errors.reject("confirm.name");
			return errors;
		}
		
		return errors;
	}
	
	private Errors nickValidChk(UserRequestDto userRequestDto, Errors errors) throws NullPointerException{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cmNick", "confirm.nick");
		
		if(service.nickNameDplChk(userRequestDto.getCmNick()) > 0) {
			errors.reject("duplicate.nick");
			return errors;
		}
		
		return errors;
	}

	private Errors phoneNumValidChk(UserRequestDto userRequestDto, Errors errors) throws NullPointerException{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cmPhone", "confirm.phoneNum");
		
		if(!ValidUtils.phoneNumChk(userRequestDto.getCmPhone())) {
			errors.reject("confirm.phoneNum");
			return errors;
		}
		
		return errors;
	}

}
