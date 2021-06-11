package com.atelier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atelier.entity.FaqEntity;

@Repository
public interface FaqRepository extends JpaRepository<FaqEntity, Long>{

}
