package com.atelier.main.user.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atelier.dto.requestDto.UserRequestDto;
import com.atelier.entity.UserEntity;
import com.atelier.enums.Roles;
import com.atelier.repository.ShippingAddrRepository;
import com.atelier.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(value = "jpaTxManager")
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final ShippingAddrRepository shippingAddrRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public int emailDplChk(String email) {
		return (userRepository.findById(email).isPresent()) ? 1 : 0;
	}
	
	@Override
	public int nickNameDplChk(String nickName) {
		return (userRepository.findById(nickName).isPresent()) ? 1 : 0;
	}
	
	@Override
	public String save(UserRequestDto dto) {
		UserEntity user = dto.toUserEntity();
		user.addRole(Roles.MEMBER);
		user.setCmPwd(passwordEncoder.encode(user.getCmPwd()));
		userRepository.save(user);
		shippingAddrRepository.save(dto.toShippingAddrEntity());
		return dto.getCmEmail();
	}
}
