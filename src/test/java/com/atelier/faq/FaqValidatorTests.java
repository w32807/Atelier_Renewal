package com.atelier.faq;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.atelier.dto.requestDto.CoNoticeRequestDto;
import com.atelier.testConfig.ApplicationContextTest;
import com.atelier.validator.CoNoticeValidator;

// result를 매번 검증하고자 하는 객체와 바인딩 시켜줘야 ValidationUtils 메소드가 제대로 작동한다.
public class FaqValidatorTests extends ApplicationContextTest{
	
	@Autowired
	private CoNoticeValidator coNoticeValidator;
	
	private CoNoticeRequestDto coNoticeRequestDto;
	
	private BindingResult result;
	
	@Before
	public void setup() {
		coNoticeRequestDto = null;
	}
	
	@Test
	public void isNullTest() {
		assertNotNull(coNoticeValidator);
	}
	
	@Test
	public void validTest1() {
		coNoticeRequestDto = CoNoticeRequestDto.builder().ntTitle("").ntCount(0).build();
		result = new BeanPropertyBindingResult(coNoticeRequestDto, "coNoticeRequestDto");
		coNoticeValidator.validate(coNoticeRequestDto, result);
		assertTrue(result.hasErrors());
	}
	
	@Test
	public void validTest2() {
		coNoticeRequestDto = CoNoticeRequestDto.builder().ntContents("").ntCount(0).build();
		result = new BeanPropertyBindingResult(coNoticeRequestDto, "coNoticeRequestDto");
		coNoticeValidator.validate(coNoticeRequestDto, result);
		assertTrue(result.hasErrors());
	}
	
	@Test
	public void validTest3() {
		coNoticeRequestDto = CoNoticeRequestDto.builder().ntTitle("타이틀").ntContents("test").ntCount(0).build();
		result = new BeanPropertyBindingResult(coNoticeRequestDto, "coNoticeRequestDto");
		coNoticeValidator.validate(coNoticeRequestDto, result);
		assertFalse(result.hasErrors());
	}
}
