package com.chandra.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.spring.bean.Person;
import com.chandra.spring.dao.PersonDAO;
@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonDAO personDAO;

	public void addPerson(Person person) {
		personDAO.addPerson(person);
		
	}

	public void editPerson(Person person, int personId) {
		personDAO.editPerson(person, personId);
		
	}

	public void deletePerson(int personId) {
		personDAO.deletePerson(personId);
		
	}

	public Person find(int personId) {
		// TODO Auto-generated method stub
		return personDAO.find(personId);
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personDAO.findAll();
	}

}
