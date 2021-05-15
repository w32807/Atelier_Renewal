package com.atelier.ADTests.ADDaoTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.dao.NT_Dao;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.testConfig.ApplicationContextTest;

public class NtDaoTest extends ApplicationContextTest{
	@Autowired
	NT_Dao ntDao;
	
	@Test
	public void nullTest() {
		assertNotNull(ntDao);
	}
	
	@Test
	public void ADNoticeInsertTest() {
		for(int i = 0; i < 1; i++) {
			CO_NoticeDto ntDto = CO_NoticeDto.builder().nt_id("admin")
					.nt_title("공지사항 타이틀")
					.nt_contents("공자사항 컨텐츠")
					.nt_num(i)
					.nt_count(0).build();
			//ntDao.ADNoticeInsert(ntDto);
		}
	}
	
	@Test
	public void getADNoticeDetail() {
		System.out.println(ntDao.getADNoticeDetail(1000));
	}
	
	@Test
	public void adNoticeUpdate() {
		CO_NoticeDto ntDto = CO_NoticeDto.builder().nt_id("admin")
				.nt_title("공지사항 타이틀 수정")
				.nt_contents("공자사항 컨텐츠 수정")
				.nt_num(2029)
				.nt_count(0).build();
		
		if(ntDao.ADNoticeUpdate(ntDto) > 0)
			System.out.println(ntDao.getADNoticeDetail(ntDto.getNt_num()));
	}

}
