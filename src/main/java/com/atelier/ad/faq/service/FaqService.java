package com.atelier.ad.faq.service;

import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.dto.pageDto.PageResultDto;
import com.atelier.dto.requestDto.FaqRequestDto;
import com.atelier.dto.responseDto.FaqResponseDto;
import com.atelier.entity.FaqEntity;

public interface FaqService {
	PageResultDto<FaqResponseDto, FaqEntity> getList(PageRequestDto requestDto);

	long save(FaqRequestDto dto);

	void delete(String[] deleteKeyList);

	FaqResponseDto getDetail(long ftNum);

}
