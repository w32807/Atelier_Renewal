package com.atelier.ADTests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.ad.service.AD_Service;
import com.atelier.dao.NT_Dao;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.dto.PageDto;
import com.atelier.testConfig.ApplicationContextTest;

public class ADServiceTests extends ApplicationContextTest{

	@Autowired
	NT_Dao ntDao;
	
	@Autowired
	AD_Service adServ;
	
	@Test
	public void isNull() {
		assertNotNull(ntDao);
		assertNotNull(adServ);
	}
	
	@Test
	public void ADNoticeInsertTest() {
		for(int i = 0; i < 1; i++) {
			CO_NoticeDto ntDto = CO_NoticeDto.builder().nt_id("admin")
					.nt_title("공지사항 타이틀")
					.nt_contents("공자사항 컨텐츠")
					.nt_num(i)
					.nt_count(0).build();
			ntDao.ADNoticeInsert(ntDto);
		}
	}
	
	@Test
	public void getADNoticeListTest() {
		PageDto pageDto = new PageDto(0, 0,  null);
		System.out.println(adServ.getADNoticeList(pageDto));
	}
	
}
