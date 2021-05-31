package com.atelier.testJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atelier.dto.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Long>{
	//void add(Person person);
	//List<Person> listPersons();
}
