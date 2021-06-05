package com.atelier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.atelier.dto.AM_Dto;
import com.atelier.dto.Person;
import com.atelier.testConfig.ApplicationContextTest;
import com.atelier.testJpa.PersonDao;

public class JpaTest extends ApplicationContextTest{

	@Autowired
	PersonDao personDao;
	
	@Autowired
	LocalContainerEntityManagerFactoryBean emf;
	
	@Test
	public void isNullChk() {
		assertNotNull(personDao);
		assertNotNull(emf);
	}
	
	@Test
	//@Rollback(false)
	@Transactional(value = "txManager")
	public void insertTest() {
		Person person = Person.builder().email("dd").build();
		personDao.saveAndFlush(person);
		//Optional<Person> p = personDao.findById(1L);
		Person p = personDao.saveAndFlush(person);
		System.out.println(p.getId());
		System.out.println(p.getEmail());
		//System.out.println(p.get().getId());
	}
}

// 1. JPA 트랜잭션과 hibernate 트랜잭션 매니저의 차이?? 
// hibernate 트랜잭션으로ㅓ 바꿔서 다시 테스트 해보자
// hibernate 소스 정리하기 (개념 블로그에 정리하기)
// junit에서는 트랜잭션으로 처리할 때 DB에 값을 넣고, 처리 후 마지막에 롤백한다.
// 마이바티스에서 트랜잭션 처리 전에는 그냥 값이 다 들어갔음