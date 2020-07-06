package com.chandra.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Spring Configuration File Loaded....");
		Triangle triangle = context.getBean("t",Triangle.class);
		System.out.println("Bean Object Created");
		triangle.draw();

	}

}
