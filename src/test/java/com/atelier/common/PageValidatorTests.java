package com.atelier.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.testConfig.ApplicationContextTest;
import com.atelier.validator.PageValidator;

public class PageValidatorTests extends ApplicationContextTest{

	@Autowired
	private PageValidator pageValidator;
	
	private PageRequestDto pageRequestDto;
	
	private BindingResult result;
	
	@Before
	public void setup() {
		pageRequestDto= null;
	}
	
	@Test
	public void isNullTest() {
		assertNotNull(pageValidator);
	}

	@Test
	public void validTest1() {
		pageRequestDto = PageRequestDto.builder().page(0).build();
		result = new BeanPropertyBindingResult(pageRequestDto, "pageRequestDto");
		pageValidator.validate(pageRequestDto, result);
		assertTrue(result.hasErrors());
	}
	@Test
	public void validTest2() {
		pageRequestDto = PageRequestDto.builder().size(-1).build();
		result = new BeanPropertyBindingResult(pageRequestDto, "pageRequestDto");
		pageValidator.validate(pageRequestDto, result);
		assertTrue(result.hasErrors());
	}
	
	@Test
	public void validTest3() {
		pageRequestDto = PageRequestDto.builder().page(0).size(-1).build();
		result = new BeanPropertyBindingResult(pageRequestDto, "pageRequestDto");
		pageValidator.validate(pageRequestDto, result);
		assertTrue(result.hasErrors());
	}
	
	@Test
	public void validTest4() {
		pageRequestDto = PageRequestDto.builder().page(1).size(10).build();
		result = new BeanPropertyBindingResult(pageRequestDto, "pageRequestDto");
		pageValidator.validate(pageRequestDto, result);
		assertFalse(result.hasErrors());
	}
}
