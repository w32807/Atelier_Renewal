package com.atelier.ADTests;



import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.ad.service.AD_Service;
import com.atelier.dto.PageDto;
import com.atelier.testConfig.ApplicationContextTest;

public class ADServiceTests extends ApplicationContextTest{
	
	@Autowired
	AD_Service adServ;
	
	@Test
	public void getADNoticeListTest() {
		PageDto pageDto = new PageDto(0, 0,  null);
		System.out.println(adServ.getADNoticeList(pageDto));
	}
	
	@Test
	public void ADNoticeDeleteTest() {
		String[] arr = {"1991"};
		adServ.ADNoticeDelete(arr);
	}
}
