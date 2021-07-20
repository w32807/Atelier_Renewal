package com.atelier.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atelier.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	@EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
	@Query(" select m from UserEntity m where m.cmEmail = :email")
	Optional<UserEntity> findByEmail(@Param("email") String email);
}
