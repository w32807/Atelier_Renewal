package com.atelier.faq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.atelier.dto.responseDto.CoNoticeResponseDto;
import com.atelier.entity.CoNoticeEntity;
import com.atelier.entity.FaqEntity;
import com.atelier.repository.FaqRepository;
import com.atelier.testConfig.ApplicationContextTest;

public class FaqRepoTests extends ApplicationContextTest{
	
	@Autowired
	private FaqRepository repository;
	
	@Test
	public void isNullTest() {
		assertNotNull(repository);
	}
	
	@Test
	@Ignore
	public void insertTest() {
		IntStream.range(1,300).forEach(i -> {
			FaqEntity faqEntity = FaqEntity.builder().ftId("admin@google.com").ftTitle(i + "번 째 글제목")
				.ftContents(i + "번 째 글내용").build();
			repository.save(faqEntity);
		});
	}
	
	@Test
	public void findByIdTest() {
		Optional<FaqEntity> faqEntity = repository.findById(12L);
		if(faqEntity.isPresent()) {
			assertEquals("12번 째 글제목", faqEntity.get().getFtTitle());
		}
	}
	
	@Test
	public void findAllTest() {
		List<FaqEntity> faqEntityList = repository.findAll();
		assertFalse(faqEntityList.isEmpty());
	}
	
	@Test 
	public void deleteTest() {
		long key = 7L;
		repository.deleteById(key);
		Optional<FaqEntity> dto = repository.findById(key); 
		
		assertFalse(dto.isPresent());
	}
}
