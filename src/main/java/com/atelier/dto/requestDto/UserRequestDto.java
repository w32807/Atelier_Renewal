package com.atelier.dto.requestDto;

import java.util.List;

import com.atelier.entity.UserEntity;
import com.google.common.base.Splitter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// RequestDto는 클라이언트에서 값을 받아올 때 사용되며,
// 서비스 혹은 DAO에서 처리되기 위한 toEntity 메소드를 가지고 있다
public class UserRequestDto{
	
	private String cmEmail;
	private String cmPwd;
	private String conCmPwd;
	private String cmName;
	private String cmNick;
	private String cmPhone;
	private String cmState;
	private String cmPfphoto;
	
	UserRequestDto(String cmEmail, String cmPwd, String conCmPwd, String cmName, String cmNick, String cmPhone){
		this.cmEmail = cmEmail;
		this.cmPwd = cmPwd;
		this.conCmPwd = conCmPwd;
		this.cmNick = cmNick;
		this.cmPhone = cmPhone;
		this.cmState = "1";
		this.cmPfphoto = "";
	}
	
	public UserEntity toEntity() {
		List<String> list = Splitter.onPattern("[. -]").trimResults().omitEmptyStrings().splitToList(cmPhone);
		
		return UserEntity.builder().cmEmail(cmEmail).cmPwd(cmPwd).cmName(cmName)
				.cmNick(cmNick).cmPhone1(list.get(0)).cmPhone2(list.get(1)).cmPhone3(list.get(2))
				.cmState(cmState).cmPfphoto(cmPfphoto).build();
	}
}
