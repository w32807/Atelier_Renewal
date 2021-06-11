package com.atelier.faq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.ad.coNotice.service.CoNoticeService;
import com.atelier.ad.faq.service.FaqService;
import com.atelier.dto.pageDto.PageRequestDto;
import com.atelier.dto.pageDto.PageResultDto;
import com.atelier.dto.responseDto.CoNoticeResponseDto;
import com.atelier.dto.responseDto.FaqResponseDto;
import com.atelier.entity.CoNoticeEntity;
import com.atelier.entity.FaqEntity;
import com.atelier.testConfig.ApplicationContextTest;

public class FaqServiceTests extends ApplicationContextTest{
	
	@Autowired
	private FaqService faqService;
	
	@Test
	public void isNullTest() {
		assertNotNull(faqService);
	}
	
	@Test
	public void getListTest() {
		PageRequestDto pageRequestDto = PageRequestDto.builder().page(2).size(10).build();
		PageResultDto<FaqResponseDto, FaqEntity> list = faqService.getList(pageRequestDto);
		for(FaqResponseDto a : list.getDtoList()) {
			System.out.println(a.toString());
		}
		assertEquals(10, list.getDtoList().size());
	}
}
