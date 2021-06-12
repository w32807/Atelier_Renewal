package com.atelier.dto.responseDto;


import java.util.Arrays;

import com.google.common.base.Joiner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto{
	private Long cmEmail;
	private String cmPwd;
	private String cmName;
	private String cmNick;
	private String cmPhone1;
	private String cmPhone2;
	private String cmPhone3;
	private String cmState;
	private String cmPfphoto;
	
	public String getPhoneNum() {
		return Joiner.on("-").join(Arrays.asList(cmPhone1.trim(), cmPhone2.trim(), cmPhone3.trim()));
	}
}
