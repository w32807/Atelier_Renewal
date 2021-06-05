package com.atelier.dto.requestDto;



import com.atelier.entity.CoNoticeEntity;

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
public class CoNoticeRequestDto{
	
	private Long ntNum;
	private String ntTitle;
	private String ntContents;
	private String ntId;
	private Integer ntCount;
	
	public CoNoticeEntity toEntity() {
		return CoNoticeEntity.builder().ntNum(ntNum).ntTitle(ntTitle)
				.ntContents(ntContents).ntId(ntId).ntCount(ntCount).build();
	}
}
