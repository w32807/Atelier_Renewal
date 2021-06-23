package com.atelier.main.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atelier.dto.requestDto.ShippingAddRequestDto;
import com.atelier.dto.requestDto.UserRequestDto;
import com.atelier.repository.ShippingAddrRepository;
import com.atelier.repository.UserRepository;
import com.google.common.base.Strings;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(value = "jpaTxManager")
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final ShippingAddrRepository shippingAddrRepository;
	
	@Override
	public int emailDplChk(String email) {
		return (userRepository.findById(email).isPresent()) ? 1 : 0;
	}
	
	@Override
	public int nickNameDplChk(String nickName) {
		return (userRepository.findById(nickName).isPresent()) ? 1 : 0;
	}
	
	@Override
	public long save(ShippingAddRequestDto dto) {
		return Optional.ofNullable(shippingAddrRepository.save(dto.toEntity())).map(entity -> entity.getSaId()).orElse(0L).longValue();
	}
	
	@Override
	public String save(UserRequestDto dto) {
		userRepository.save(dto.toEntity());
		//return Optional.ofNullable(userRepository.save(dto.toEntity())).map(entity -> entity.getCmEmail()).orElse("");
		return "";
	}
	
	@Override
	public long userSave(UserRequestDto user, ShippingAddRequestDto shipping) {
		return (this.save(shipping) > 0 && !Strings.isNullOrEmpty(this.save(user))) ? 1L : 0L;
	}
}
