package com.atelier.User;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.atelier.dto.requestDto.UserRequestDto;
import com.atelier.testConfig.ApplicationContextTest;
import com.atelier.validator.UserValidator;

public class UserValidatorTests extends ApplicationContextTest{

	@Autowired
	private UserValidator userValidator;
	
	private UserRequestDto userRequestDto;
	
	private BindingResult result;
	
	@Before
	public void setup() {
		userRequestDto = null;
	}
	
	@Test
	public void isNullTest() {
		assertNotNull(userValidator);
	}
	
	@Test
	public void validTest1() {
		userRequestDto = UserRequestDto.builder().cmEmail("ddd").cmPwd("dd").build();
		result = new BeanPropertyBindingResult(userRequestDto, "userRequestDto");
		userValidator.validate(userRequestDto, result);
	}
}
