package com.atelier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.atelier.dto.responseDto.FaqResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DynamicInsert // (insert 시 null인 필드 제외) -> db의 컬럼은 not null로 잡고, default 값을 설정하여 해당 값 설정 가능
@Table(name = "FAQ")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class FaqEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FT_NUM")
	private Long ftNum;
	
	@Column(name = "FT_TITLE", length = 100, nullable = false, columnDefinition = "varchar(100) default ''")
	private String ftTitle;
	
	@Column(name = "FT_CONTENTS", length = 1000, nullable = false, columnDefinition = "varchar(1000) default ''")
	private String ftContents;
	
	@Column(name = "FT_ID  ", length = 50, columnDefinition = "varchar(50) default ''")
	private String ftId;
	
	@Column(name = "FT_COUNT", columnDefinition = "integer default 0")
	private Integer ftCount;
	
	public FaqResponseDto toDto() {
		return FaqResponseDto.builder().ftNum(ftNum).ftTitle(ftTitle)
				.ftContents(ftContents).ftId(ftId).ftCount(ftCount).build();
	}
}
