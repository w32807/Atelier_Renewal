package com.atelier.coNotice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.entity.CoNoticeEntity;
import com.atelier.repository.CoNoticeRepository;
import com.atelier.testConfig.ApplicationContextTest;

public class CoNoticeRepoTests extends ApplicationContextTest{
	
	@Autowired
	private CoNoticeRepository repository;
	
	@Test
	public void isNullTest() {
		assertNotNull(repository);
	}
	
	@Test
	@Ignore
	public void insertTest() {
		IntStream.range(1,300).forEach(i -> {
			CoNoticeEntity coNoticeEntity = CoNoticeEntity.builder().ntId("admin@google.com").ntTitle(i + "번 째 글제목")
				.ntContents(i + "번 째 글내용").ntCount(0).build();
			repository.save(coNoticeEntity);
		});
	}
	
	@Test
	public void findByIdTest() {
		Optional<CoNoticeEntity> coNoticeEntity = repository.findById(12L);
		if(coNoticeEntity.isPresent()) {
			assertEquals("12번 째 글제목", coNoticeEntity.get().getNtTitle());
		}
	}
	
	@Test
	public void findAllTest() {
		List<CoNoticeEntity> coNoticeEntityList = repository.findAll();
		assertFalse(coNoticeEntityList.isEmpty());
	}
}
