package com.atelier.dto.responseDto;


import com.atelier.entity.UserEntity;
import com.google.common.base.Joiner;

import lombok.Data;

@Data
public class UserResponseDto{
	
	public UserResponseDto(UserEntity user){
		this.cmEmail = user.getCmEmail();
		this.cmPwd = user.getCmPwd();
		this.cmName = user.getCmName();
		this.cmNick = user.getCmNick();
		this.cmPhoneNum = Joiner.on("-").join(user.getCmPhone1().trim(), user.getCmPhone2().trim(), user.getCmPhone3().trim());
		this.cmState = user.getCmState();
		this.cmPfphoto = user.getCmPfphoto();
	}
	
	private String cmEmail;
	private String cmPwd;
	private String cmName;
	private String cmNick;
	private String cmPhoneNum;
	private String cmState;
	private String cmPfphoto;
	
}
