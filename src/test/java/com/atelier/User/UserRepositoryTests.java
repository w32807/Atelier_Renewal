package com.atelier.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.atelier.dto.responseDto.UserResponseDto;
import com.atelier.entity.UserEntity;
import com.atelier.repository.UserRpository;
import com.atelier.testConfig.ApplicationContextTest;
import com.google.common.base.Joiner;

public class UserRepositoryTests extends ApplicationContextTest{

	@Autowired
	UserRpository repository; 
	
	@Test
	public void isNullTest() {
		assertNotNull(repository);
	}
	
	@Test
	@Ignore
	public void insertTest() {
		IntStream.range(1,300).forEach(i -> {
			UserEntity userEntity = UserEntity.builder().cmEmail("user" + i +"@google.com").cmPwd("비밀번호"+i)
				.cmName("user" + i).cmNick("userNick" + i).cmPhone1("010").cmPhone2("1234 ").cmPhone3("5678").cmState("1").cmPfphoto("").build();
			repository.save(userEntity);
		});
	}
	
	@Test
	public void findByIdTest() {
		Optional<UserEntity> userEntity = repository.findById("user5@google.com");
		if(userEntity.isPresent()) {
			assertEquals("user5@google.com", userEntity.get().getCmEmail());
		}
	}
	
	@Test
	public void findAllTest() {
		List<UserEntity> userEntityList = repository.findAll();
		assertFalse(userEntityList.isEmpty());
	}
	
	@Test 
	@Ignore
	public void deleteTest() {
		String key = "user5@google.com";
		repository.deleteById(key);
		Optional<UserEntity> dto = repository.findById(key); 
		
		assertFalse(dto.isPresent());
	}
	
	@Test
	public void getPhoneNum() {
		Optional<UserEntity> userEntity = repository.findById("user17@google.com");
		if(userEntity.isPresent()) {
			UserResponseDto userResponseDto = userEntity.get().toDto();
			;
			assertEquals(Joiner.on("-").join(userResponseDto.getCmPhone1().trim(), userResponseDto.getCmPhone2().trim(), userResponseDto.getCmPhone3().trim())
						, userResponseDto.getPhoneNum());
		}
	}
}
