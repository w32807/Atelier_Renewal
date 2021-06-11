package com.atelier.ad.coNotice.service;

import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.dto.pageDto.PageResultDto;
import com.atelier.dto.requestDto.CoNoticeRequestDto;
import com.atelier.dto.responseDto.CoNoticeResponseDto;
import com.atelier.entity.CoNoticeEntity;

public interface CoNoticeService {

	PageResultDto<CoNoticeResponseDto, CoNoticeEntity> getList(PageRequestDto requestDto);

	long save(CoNoticeRequestDto dto);

	void delete(String[] deleteKeyList);

	CoNoticeResponseDto getDetail(long ntNum);
}
