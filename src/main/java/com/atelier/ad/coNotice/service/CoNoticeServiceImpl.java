package com.atelier.ad.coNotice.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.dto.pageDto.PageResultDto;
import com.atelier.dto.requestDto.CoNoticeRequestDto;
import com.atelier.dto.responseDto.CoNoticeResponseDto;
import com.atelier.entity.CoNoticeEntity;
import com.atelier.repository.CoNoticeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(value = "jpaTxManager")
public class CoNoticeServiceImpl implements CoNoticeService {
	
	private final CoNoticeRepository coNoticeRepository;

	@Override
	@Transactional(value = "jpaTxManager" , readOnly = true)
	public PageResultDto<CoNoticeResponseDto, CoNoticeEntity> getList(PageRequestDto requestDto) {
		// 어떻게 paging을 할 것인지 설정 (Sort는 DB의 컬럼명이 아닌 Entity의 속성명을 따라간다.
		Page<CoNoticeEntity> result = coNoticeRepository.findAll(requestDto.getPageable(Sort.by("ntNum").descending()));
		Function<CoNoticeEntity, CoNoticeResponseDto> fn = (entity -> entity.toDto());
		return new PageResultDto<CoNoticeResponseDto, CoNoticeEntity>(result, fn);
	}
	
	@Override
	public long save(CoNoticeRequestDto dto) {
		// Optional을 이용해서, insert 후 반환하는 객체를 null 체크하여 유효성검사 
		return Optional.ofNullable(coNoticeRepository.save(dto.toEntity())).map(entity -> entity.getNtNum()).orElse(0L).longValue();
	}
	
	@Override
	@Transactional(value = "jpaTxManager" , readOnly = true)
	public CoNoticeResponseDto getDetail(long ntNum) {
		coNoticeRepository.findById(ntNum);
		return Optional.ofNullable(coNoticeRepository.findById(ntNum)).map(optionalResult -> optionalResult.get().toDto()).orElse(null);
	}
	
	@Override
	public void delete(String[] deleteKeyList) {
		for(String deleteKey : deleteKeyList) {
			coNoticeRepository.deleteById(Long.valueOf(deleteKey));
		}
	}
}
