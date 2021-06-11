package com.atelier.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.atelier.dto.pageDto.PageRequestDto;

@Component
public class PageValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return (PageRequestDto.class.isAssignableFrom(clazz));
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		PageRequestDto pageRequestDto = (PageRequestDto) target;
		if (pageRequestDto.getPage() < 1 || pageRequestDto.getSize() < 0) {
			errors.reject("field.page");
		}
	}
}
