package com.atelier.dto.responseDto;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.atelier.entity.UserEntity;
import com.google.common.base.Joiner;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class UserResponseDto extends User{

	private String cmEmail;
	private String cmPwd;
	private String cmName;
	private String cmNick;
	private String cmPhoneNum;
	private String cmState;
	private String cmPfphoto;
	
	public UserResponseDto(UserEntity user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getCmEmail(), user.getCmPwd(), authorities);
		this.cmEmail = user.getCmEmail();
		this.cmPwd = user.getCmPwd();
		this.cmName = user.getCmName();
		this.cmNick = user.getCmNick();
		this.cmPhoneNum = Joiner.on("-").join(user.getCmPhone1().trim(), user.getCmPhone2().trim(), user.getCmPhone3().trim());
		this.cmState = user.getCmState();
		this.cmPfphoto = user.getCmPfphoto();
	}
}
