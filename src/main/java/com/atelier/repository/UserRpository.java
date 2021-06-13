package com.atelier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atelier.entity.UserEntity;

@Repository
public interface UserRpository extends JpaRepository<UserEntity, String>{

}
