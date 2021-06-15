package com.atelier.dto.responseDto;

import com.atelier.entity.FaqEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class FaqResponseDto {
	
	public FaqResponseDto(FaqEntity faqEntity){
		this.ftNum = faqEntity.getFtNum();
		this.ftTitle = faqEntity.getFtTitle();
		this.ftContents = faqEntity.getFtContents();
		this.ftId = faqEntity.getFtId();
		this.ftCount = faqEntity.getFtCount();
	}
	
	private Long ftNum;
	private String ftTitle;
	private String ftContents;
	private String ftId;
	private Integer ftCount;
}
