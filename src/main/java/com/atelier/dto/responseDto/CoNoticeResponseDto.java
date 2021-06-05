package com.atelier.dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoNoticeResponseDto{
	private Long ntNum;
	private String ntTitle;
	private String ntContents;
	private String ntId;
	private Integer ntCount;
}
