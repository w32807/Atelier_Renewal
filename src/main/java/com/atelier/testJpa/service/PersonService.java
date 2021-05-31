package com.atelier.testJpa.service;

import java.util.List;

import com.atelier.dto.Person;

public interface PersonService {
	void add(Person person);
	List<Person> listPersons();
}
