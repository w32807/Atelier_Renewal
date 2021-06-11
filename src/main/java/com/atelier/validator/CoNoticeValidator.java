package com.atelier.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.atelier.dto.requestDto.CoNoticeRequestDto;

@Component
public class CoNoticeValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// instanceof : 특정 Object가 상속, 구현받았는지 확인
		// isAssignableFrom : 특정 Class가 상속, 구현받았는지 확인 (그래서 .class.isAssignableFrom 가 된다)
		return (CoNoticeRequestDto.class.isAssignableFrom(clazz));
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// 각종 유효성 검사가 구현되는 곳
		// 특정 필드에서 NPT가 일어나면 이 메소드의 기능이 상실 되므로, 항상 null 체크를 잘 해주어야 한다.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ntTitle", "field.required.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ntContents", "field.required.content");
	}
}
