package com.atelier.utils;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

import com.atelier.entity.CoNoticeEntity;

public class UtilsTests {

	@Test
	public void pageListTest() {
		int page = 1;
		assertEquals(10, (int)(Math.ceil(page/10.0)) * 10);
	}
	
	@Test
	public void optioanalNullTest() {
		CoNoticeEntity coNoticeEntity = null;
		assertEquals(0L, Optional.ofNullable(coNoticeEntity).map(entity -> entity.getNtNum()).orElse(0L).longValue());
		
		coNoticeEntity = CoNoticeEntity.builder().ntNum(10L).ntTitle("test Title").build();
		assertEquals(coNoticeEntity.getNtNum(), Optional.ofNullable(coNoticeEntity.getNtNum()).orElse(0L));
	}
}
