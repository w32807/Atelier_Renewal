package com.atelier.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.dto.requestDto.ShippingAddRequestDto;
import com.atelier.dto.requestDto.UserRequestDto;
import com.atelier.main.user.service.UserService;
import com.atelier.testConfig.ApplicationContextTest;

public class UserServiceTest extends ApplicationContextTest{
	
	@Autowired
	UserService service;
	
	public void isNullTest() {
		assertNotNull(service);
	}
	
	public void emailDplChkTest() {
		assertNotEquals(service.emailDplChk("1234"), 1);
	}
	
	@Test
	public void userInsertTest() {
		UserRequestDto user = UserRequestDto.builder().cmEmail("w32807@nate.com").cmPhone("010-1234-5678").build();
		assertEquals(user.getCmEmail(), service.save(user));
		
		//ShippingAddRequestDto shipping = ShippingAddRequestDto.builder().saId(1L).build();
		//assertEquals(1L, service.userSave(user, shipping));
	}

}
