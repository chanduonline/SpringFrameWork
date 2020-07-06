package com.chandra.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chandra.spring.bean.Person;
@Repository
@Qualifier("personDAO")
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addPerson(Person person) {
		jdbcTemplate.update("INSERT INTO person(first_name,last_name,age)VALUES(?,?,?)",
				person.getFirstName(),person.getLastName(),person.getAge());
		System.out.println("Person Details Added Successfully....");
		
	}

	public void editPerson(Person person, int personId) {
		jdbcTemplate.update("UPDATE person SET first_name=?,last_name=?,age=? WHERE person_id=?",
				person.getFirstName(),person.getLastName(),person.getAge(),personId);
		System.out.println("Person Details Updated Successfully....");
		
	}

	public void deletePerson(int personId) {
		jdbcTemplate.update("DELETE FROM person WHERE person_id=?",personId);
		System.out.println("Person Details Deleted Successfully....");
		
	}

	public Person find(int personId) {
		Person person = jdbcTemplate.queryForObject("SELECT * FROM person  WHERE person_id=?",
				new Object[]{personId},new BeanPropertyRowMapper(Person.class));
		return person;
	}

	public List<Person> findAll() {
		List<Person> persons = jdbcTemplate.query("SELECT * FROM person",new BeanPropertyRowMapper(Person.class));
		return persons;
	}

}
