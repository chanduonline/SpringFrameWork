package com.chandra.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Spring Configuration Loaded");
		Welcome welcome = context.getBean("w", Welcome.class);
		Welcome welcome1 = context.getBean("w", Welcome.class);
		Welcome welcome2 = context.getBean("w", Welcome.class);
		welcome.sayHello();
		

	}

}
