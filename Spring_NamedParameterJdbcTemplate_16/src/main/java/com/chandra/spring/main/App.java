package com.chandra.spring.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.chandra.spring.bean.Person;
import com.chandra.spring.configuration.ApplicationConfig;
import com.chandra.spring.service.PersonService;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PersonService personService = context.getBean("personService",PersonService.class);
	/*	
		Person p1 = new Person("ABC","A",25);
		Person p2 = new Person("PQR","P",35);
		Person p3 = new Person("XYZ","X",22);

		personService.addPerson(p1);
		personService.addPerson(p2);
		personService.addPerson(p3);
		
		System.out.println("Find All Person Details");
		List<Person> persons = personService.findAll();
		for(Person person:persons)
		{
			System.out.println(person);
		}
		
		System.out.println("Delete Person Id = 3");
		int deleteId=3;
		personService.deletePerson(deleteId);
		
		
		p2.setFirstName("PPP");
		p2.setLastName("P1");
		p2.setAge(33);
		int updatedId=2;
		personService.editPerson(p2, updatedId);*/
		
		System.out.println("Find Person Details =2");
		int findId = 10;
		Person person=personService.find(findId);
		System.out.println(person);
		
		context.close();
	}

}
