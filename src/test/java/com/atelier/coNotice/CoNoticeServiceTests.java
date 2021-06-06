package com.atelier.coNotice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.ad.coNotice.service.CoNoticeService;
import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.dto.pageDto.PageResultDto;
import com.atelier.dto.responseDto.CoNoticeResponseDto;
import com.atelier.entity.CoNoticeEntity;
import com.atelier.testConfig.ApplicationContextTest;

public class CoNoticeServiceTests extends ApplicationContextTest{
	
	@Autowired
	private CoNoticeService coNoticeService;
	
	@Test
	public void isNullTest() {
		assertNotNull(coNoticeService);
	}
	
	@Test
	public void getListTest() {
		PageRequestDto pageRequestDto = PageRequestDto.builder().page(2).size(10).build();
		PageResultDto<CoNoticeResponseDto, CoNoticeEntity> list = coNoticeService.getList(pageRequestDto);
		assertEquals(10, list.getDtoList().size());
	}
}
