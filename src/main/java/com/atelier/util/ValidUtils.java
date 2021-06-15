package com.atelier.util;

import java.util.regex.Pattern;

//자바의 정규식에서는 양 끝에 /를 넣어주면 안됨
public class ValidUtils {
	
	public static boolean emailChk(String email) {
        String pattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        return Pattern.matches(pattern, email.trim());
	}
	
	public static boolean phoneNumChk(String phoneNum) {
		String pattern = "^\\d{2,3}[- .]\\d{3,4}[- .]\\d{4}";
		return Pattern.matches(pattern, phoneNum.trim());
	}
	
	public static boolean pwdChk(String pwd) {
		String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}";
		return Pattern.matches(pattern, pwd.trim());
	}
	
	public static boolean nameChk(String name) {
		String pattern = "^[가-힣a-zA-Z]+$";
		return Pattern.matches(pattern, name.trim());
	}
}
