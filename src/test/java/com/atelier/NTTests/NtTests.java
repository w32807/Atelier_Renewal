package com.atelier.NTTests;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.ad.service.AD_Service;
import com.atelier.dao.NT_Dao;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.testConfig.ApplicationContextTest;

public class NtTests extends ApplicationContextTest{

	@Autowired
	NT_Dao ntDao;
	
	@Autowired
	AD_Service adServ;
	
	@Test
	public void ADNoticeInsertTest() {
		CO_NoticeDto ntDto = CO_NoticeDto.builder().nt_id("admin")
									.nt_title("공지사항 타이틀")
									.nt_contents("공자사항 컨텐츠")
									.nt_num(1)
									.nt_count(1).build();
		ntDao.ADNoticeInsert(ntDto);
	}
}
