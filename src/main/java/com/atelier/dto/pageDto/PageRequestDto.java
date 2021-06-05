package com.atelier.dto.pageDto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.*;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDto {
	private int page;
	private int size;
	
	public PageRequestDto() {
		this.page = 1;
		this.size = 10;
	}
	
	public Pageable getPageable(Sort sort) {
		return PageRequest.of(page - 1, size, sort);
	}
}
