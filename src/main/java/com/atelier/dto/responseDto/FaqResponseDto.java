package com.atelier.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FaqResponseDto {
	private Long ftNum;
	private String ftTitle;
	private String ftContents;
	private String ftId;
	private Integer ftCount;
}
