package com.chandra.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestAnnotationBasedApplication {

	public static void main(String[] args) {
	//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	System.out.println("Spring Configuration File Loaded....");
	Hello h = context.getBean("helloObj",Hello.class);
	System.out.println("Bean Object Created");
	h.setName("Chandra");
	System.out.println("Welcome to Spring Annotations Mr. "+h.getName());

	}

}
