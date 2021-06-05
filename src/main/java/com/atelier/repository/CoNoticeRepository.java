package com.atelier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atelier.entity.CoNoticeEntity;

@Repository
public interface CoNoticeRepository  extends JpaRepository<CoNoticeEntity, Long>{

}
