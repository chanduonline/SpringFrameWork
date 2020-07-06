package com.chandra.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandra.spring.bean.Person;
import com.chandra.spring.service.PersonService;

@RestController
public class PersonController {

    @Autowired
	PersonService personService;
	
	@RequestMapping("/persons")
	public List<Person> getPersons() {
		List<Person> persons =personService.findAll();
		return persons;
	}
    @RequestMapping("/person/{id}")
	public Person person(@PathVariable("id")int personId) {
		for (Person person : getPersons()) {
			if (person.getPersonId() == personId) {
				return person;
				
			}
		}
		return null;
	}
    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id")int personId)
    {
    	personService.deletePerson(personId);
    	return "Successfuly person Deleted";
    	
    }

}
