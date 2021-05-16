package com.atelier.ADTests.ADDaoTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.dao.AD_Dao;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.dto.FT_FAQDto;
import com.atelier.dto.PageDto;
import com.atelier.testConfig.ApplicationContextTest;

public class AdDaoTests extends ApplicationContextTest{
	@Autowired
	AD_Dao adDao;
	
	@Test
	public void isNullChk() {
		assertNotNull(adDao);
	}
	
	@Test
	public void getFAQCountTest() {
		System.out.println(adDao.getFAQCount());
	}
	
	@Test
	public void getFAQListTest() {
		PageDto pageDto = new PageDto();
		System.out.println(adDao.getFAQList(pageDto));
	}
	
	//@Test
	public void FAQInsertTest() {
		for(int i = 0; i < 2000; i++) {
			FT_FAQDto ftFAQDto = FT_FAQDto.builder().
					ft_title("글제목 " + i).ft_contents("글내용 " + i).ft_id("작성자 " + i).build();
			adDao.FAQInsert(ftFAQDto);
		}
	}
	
	@Test
	public void getFAQDetailTest() {
		System.out.println(adDao.getFAQDetail(1));
	}
	
	@Test
	public void getFAQupdateTest() {
		FT_FAQDto ftFAQDto = FT_FAQDto.builder().
				ft_num(1).ft_title("글제목 업데이트 ").ft_contents("글내용 업데이트").ft_id("작성자 업데이트").build();
		adDao.FAQupdate(ftFAQDto);
		System.out.println(adDao.getFAQDetail(1));
	}
	
	@Test
	public void delFAQTest() {
		String[] arr = {"2256","2255","2254"};
		System.out.println("삭제 후 >> " + adDao.delFAQ(arr));
	}
}
