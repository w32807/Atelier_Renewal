package com.atelier.vo;

import com.atelier.dto.requestDto.ShippingAddRequestDto;
import com.atelier.dto.requestDto.UserRequestDto;

import lombok.Data;

@Data
public class UserVo {

	UserRequestDto user;
	ShippingAddRequestDto shipping;
	
}
