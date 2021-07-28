package com.atelier.main.login.service;


import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.atelier.dto.responseDto.UserResponseDto;
import com.atelier.entity.UserEntity;
import com.atelier.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> result = repository.findByEmail(username);
		// 입력받은 이메일로 저장된 사용자 데이터가 없다면 LoginFailureHandler로 이동
		if(!result.isPresent()) throw new UsernameNotFoundException("이메일을 확인 해 주세요.");
		
		UserEntity user = result.get();
		
		// UserResultDto가 User 클래스를 상속받고, 생성자를 만들어줘야 됨
		return new UserResponseDto(user, user.getRoleSet().stream()
							.map(role -> new SimpleGrantedAuthority("ROLE_"+role.name())).collect(Collectors.toList()));
	}
}
