package com.atelier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atelier.entity.UserEntity;

public interface LoginRepository extends JpaRepository<UserEntity, String>{

}
