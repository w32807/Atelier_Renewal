package com.atelier.dto.requestDto;

import com.atelier.entity.FaqEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FaqRequestDto {
	private Long ftNum;
	private String ftTitle;
	private String ftContents;
	private String ftId;
	private Integer ftCount;
	
	public FaqEntity toEntity() {
		return FaqEntity.builder().ftNum(ftNum).ftTitle(ftTitle)
				.ftContents(ftContents).ftId(ftId).ftCount(ftCount).build();
	}
}
