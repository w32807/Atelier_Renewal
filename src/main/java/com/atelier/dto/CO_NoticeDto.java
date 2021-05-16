package com.atelier.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CO_NoticeDto  extends BaseDto{
	private int nt_num; // 공지사항 번호
	private int nt_count; // 조회수
	private String nt_title; // 공지사항 제목
	private String nt_contents; // 공지사항 내용
	private String nt_id; // 작성자 ID
}
