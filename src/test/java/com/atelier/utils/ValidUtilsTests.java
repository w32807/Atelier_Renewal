package com.atelier.utils;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.atelier.enums.Roles;
import com.atelier.util.ValidUtils;


public class ValidUtilsTests {
	
	@Test
	public void emaliChkTest() {
		assertTrue(ValidUtils.emailChk("user1@google.com"));
		assertTrue(ValidUtils.emailChk("user1@goo-gle.com"));
		assertTrue(ValidUtils.emailChk("user1@google.com"));
		assertFalse(ValidUtils.emailChk("user1@google..com"));
		assertFalse(ValidUtils.emailChk("user1@google,com"));
	}
	
	@Test
	public void phoneNumChkTest() {
		assertTrue(ValidUtils.phoneNumChk("010-1234-5687"));
		assertTrue(ValidUtils.phoneNumChk("02-056-1248"));
		assertTrue(ValidUtils.phoneNumChk("010 9597 1234"));
		assertFalse(ValidUtils.phoneNumChk("01012345678"));
		assertFalse(ValidUtils.phoneNumChk("123^1234%5469"));
		assertFalse(ValidUtils.phoneNumChk("010-12345-1245"));
	}
	
	@Test
	public void pwdChkTest() {
		assertTrue(ValidUtils.pwdChk("wqrqzsdfD12@&"));
		assertTrue(ValidUtils.pwdChk("Dafq12412d@2"));
		assertTrue(ValidUtils.pwdChk("Dartgg1@"));
		assertFalse(ValidUtils.pwdChk("12df"));
		assertFalse(ValidUtils.pwdChk("asdasdfgsg@"));
		assertFalse(ValidUtils.pwdChk("adsad12dasd"));
	}
	
	@Test
	public void nameChkTest() {
		assertTrue(ValidUtils.nameChk("asdasd"));
		assertTrue(ValidUtils.nameChk("가나다"));
		assertFalse(ValidUtils.nameChk("12ㄴㅁㅇ"));
		assertFalse(ValidUtils.nameChk("ㄴㅁㄴ#ㄹ"));
		assertFalse(ValidUtils.nameChk(" "));
		assertFalse(ValidUtils.nameChk("ㅈㄱ2"));
	}
	
	@Test
	public void test() {
		System.out.println(Roles.ADMIN);
		System.out.println(Roles.ATRELIER);
	}

}
