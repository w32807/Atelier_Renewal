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
	
	@Test
	public void isNullTest() {
		assertNotNull(service);
	}
	
	@Test
	public void emailDplChkTest() {
		assertNotEquals(service.emailDplChk("1234"), 1);
	}
	
	@Test
	public void userInsertTest() {
		UserRequestDto user = UserRequestDto.builder().cmEmail("w32807@nate.com").cmName("원준").cmNick("닉네임")
											.cmPwd("dd").conCmPwd("").cmPhone("010-1234-5678").build();
		ShippingAddRequestDto shipping = ShippingAddRequestDto.builder().saId(1L).saAddrDetail("123호").saAddrHead("dddsad").build();
		assertEquals(1L, service.userSave(user, shipping));
	}

}
