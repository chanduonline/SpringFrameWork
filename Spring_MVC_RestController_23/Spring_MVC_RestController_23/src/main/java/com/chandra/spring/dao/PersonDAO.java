package com.chandra.spring.dao;

import java.util.List;

import com.chandra.spring.bean.Person;

public interface PersonDAO {
	
	public void addPerson(Person person);
	public void editPerson(Person person,int personId);
	public void deletePerson(int personId);
	public Person find(int personId);
	public List<Person> findAll();

}
