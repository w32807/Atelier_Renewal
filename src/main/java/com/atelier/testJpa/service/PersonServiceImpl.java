package com.atelier.testJpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl {
	/*
	@Autowired
	private PersonDao userDao;

	@Override
	@Transactional
	public void add(Person person) {
		userDao.add(person);
	}
	
	@Override
	@Transactional
	public List<Person> listPersons() {
		return userDao.listPersons();
	}
	*/
}
