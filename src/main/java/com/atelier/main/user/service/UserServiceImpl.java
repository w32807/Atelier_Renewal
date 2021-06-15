package com.atelier.main.user.service;

import org.springframework.stereotype.Service;

import com.atelier.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	@Override
	public int emailDplChk(String email) {
		return (userRepository.findById(email).isPresent()) ? 1 : 0;
	}
	
	@Override
	public int nickNameDplChk(String nickName) {
		return (userRepository.findById(nickName).isPresent()) ? 1 : 0;
	}
}
