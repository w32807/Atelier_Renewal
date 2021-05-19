package com.atelier.aopTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.common.controller.ControllerLoggerAdvice;
import com.atelier.testConfig.ApplicationContextTest;

public class AopTests extends ApplicationContextTest{

	@Autowired
	ControllerLoggerAdvice logger;
	
	@Test
	public void isNull() {
		assertNotNull(logger);
	}
}
