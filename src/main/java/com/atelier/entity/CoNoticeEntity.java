package com.atelier.entity;

import javax.persistence.*;

import com.atelier.dto.responseDto.CoNoticeResponseDto;

import lombok.*;

@Entity
@Table(name = "NOTICES")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
// Entity와 동일한 구성을 가진 RequestDto, ResponseDto를 같이 선언하여 
// 변화에 유연하게 대응할 수 있도록 구성
public class CoNoticeEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NT_NUM")
	private Long ntNum;
	
	@Column(name = "NT_TITLE", length = 100, nullable = false, columnDefinition = "varchar(100) ''")
	private String ntTitle;
	
	@Column(name = "NT_CONTENTS", length = 1000, nullable = false, columnDefinition = "varchar(1000) ''")
	private String ntContents;
	
	@Column(name = "NT_ID", length = 50, nullable = false, columnDefinition = "varchar(50) ''")
	private String ntId;
	
	@Column(name = "NT_COUNT", nullable = false, columnDefinition = "integer default 0")
	private Integer ntCount;
	
	public CoNoticeResponseDto toDto() {
		return CoNoticeResponseDto.builder().ntNum(ntNum).ntTitle(ntTitle)
				.ntContents(ntContents).ntId(ntId).ntCount(ntCount).build();
	}
}
