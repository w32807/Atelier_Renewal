package com.atelier.transactionTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.atelier.ad.service.AD_Service;
import com.atelier.dto.CO_NoticeDto;
import com.atelier.dto.PageDto;
import com.atelier.testConfig.ApplicationContextTest;

public class AdTransactionTest extends ApplicationContextTest{

	@Autowired
	AD_Service adServ;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Test
	public void isNull() {
		assertNotNull(adServ);
		assertNotNull(transactionManager);
	}
	
	@Test (expected = TransientDataAccessResourceException.class)
	public void getAdNoticeListTest() {
		// 트랜잭션 동기화를 통해서, 1,2번의 메소드를 1개의 트랜잭션에서 처리한다.
		DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
		txDefinition.setReadOnly(true);

		TransactionStatus status = transactionManager.getTransaction(txDefinition);
		// 1. readonly = true로 처리 될 메소드
		adServ.getADNoticeList(new PageDto());
		// 2. readonly = false로 처리 될 메소드
		for(int i = 0; i < 1; i++) {
			CO_NoticeDto ntDto = CO_NoticeDto.builder().nt_id("admin")
					.nt_title("공지사항 타이틀")
					.nt_contents("공지사항 컨텐츠")
					.nt_num(i)
					.nt_count(0).build();
			adServ.ADNoticeInsert(ntDto);
		}
		transactionManager.commit(status);
	}
}

