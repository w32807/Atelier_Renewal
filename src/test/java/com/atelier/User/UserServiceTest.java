package com.atelier.User;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
