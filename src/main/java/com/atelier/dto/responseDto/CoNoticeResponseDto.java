package com.atelier.dto.responseDto;


import com.atelier.entity.CoNoticeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CoNoticeResponseDto{
	
	public CoNoticeResponseDto(CoNoticeEntity coNoticeEntity){
		this.ntNum = coNoticeEntity.getNtNum();
		this.ntTitle = coNoticeEntity.getNtTitle();
		this.ntContents = coNoticeEntity.getNtContents();
		this.ntId = coNoticeEntity.getNtId();
		this.ntCount = coNoticeEntity.getNtCount();
	}
	
	private Long ntNum;
	private String ntTitle;
	private String ntContents;
	private String ntId;
	private Integer ntCount;
}
