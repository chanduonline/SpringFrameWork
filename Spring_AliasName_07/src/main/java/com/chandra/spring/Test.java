package com.chandra.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Spring Configuration Loaded");
		Welcome welcome = context.getBean("w_alias", Welcome.class);
		welcome.sayHello();
		

	}

}
