package com.atelier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FT_FAQDto extends BaseDto{
	private int ft_num; // 글번호
	private int ft_count; // 조회수
	private String ft_title;// 제목
	private String ft_contents;// 내용
	private String ft_id;// 작성자
}
