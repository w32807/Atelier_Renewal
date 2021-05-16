package com.atelier.dto;

import java.util.Date;

import lombok.Data;

@Data
public abstract class BaseDto {
	protected Date reg_date; // 등록시간
	protected Date mod_date; // 수정시간
}
