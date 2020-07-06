package com.chandra.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Spring Configuration File Loaded.....");
		Circle c = context.getBean("c",Circle.class);
		System.out.println("Object Created");
		c.draw();
		
		Car car = context.getBean(Car.class);
		car.carColor();
	}

}
