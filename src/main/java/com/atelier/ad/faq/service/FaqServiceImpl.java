package com.atelier.ad.faq.service;


import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.dto.pageDto.PageResultDto;
import com.atelier.dto.requestDto.FaqRequestDto;
import com.atelier.dto.responseDto.CoNoticeResponseDto;
import com.atelier.dto.responseDto.FaqResponseDto;
import com.atelier.entity.CoNoticeEntity;
import com.atelier.entity.FaqEntity;
import com.atelier.repository.FaqRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(value = "jpaTxManager")
public class FaqServiceImpl implements FaqService{
	
	private final FaqRepository faqRepository;
	
	@Override
	@Transactional(value = "jpaTxManager" , readOnly = true)
	public PageResultDto<FaqResponseDto, FaqEntity> getList(PageRequestDto requestDto) {
		Page<FaqEntity> result = faqRepository.findAll(requestDto.getPageable(Sort.by("ftNum").descending()));
		Function<FaqEntity, FaqResponseDto> fn = (entity -> entity.toDto());
		return new PageResultDto<FaqResponseDto, FaqEntity>(result, fn);
	}
	
	@Override
	public long save(FaqRequestDto dto) {
		return Optional.ofNullable(faqRepository.save(dto.toEntity())).map(entity -> entity.getFtNum()).orElse(0L).longValue();
	}
	
	@Override
	@Transactional(value = "jpaTxManager" , readOnly = true)
	public FaqResponseDto getDetail(long ftNum) {
		faqRepository.findById(ftNum);
		return Optional.ofNullable(faqRepository.findById(ftNum)).map(optionalResult -> optionalResult.get().toDto()).orElse(null);
	}
	
	@Override
	public void delete(String[] deleteKeyList) {
		for(String deleteKey : deleteKeyList) {
			faqRepository.deleteById(Long.valueOf(deleteKey));
		}
	}

	


	
	

}
