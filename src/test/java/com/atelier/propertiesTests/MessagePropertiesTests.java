package com.atelier.propertiesTests;

import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.atelier.testConfig.ApplicationContextTest;

public class MessagePropertiesTests extends ApplicationContextTest{
	
	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	
	@Test
	public void isNullTest() {
		assertNotNull(messageSource);
		Locale.setDefault(Locale.ROOT);
		System.out.println(messageSource.getMessage("confirm.email", new String[] {"메세지를 꺼내올 key"}, Locale.KOREA));
	}
}
