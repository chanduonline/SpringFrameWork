package com.chandra.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Configuration class Loaded...");
		FirstBean first = context.getBean("one",FirstBean.class);
		FirstBean first1 = context.getBean("one",FirstBean.class);
		FirstBean first2 = context.getBean("one",FirstBean.class);
		first.test();
		/*SecondBean second = context.getBean("secondBean",SecondBean.class);
		second.test();*/

	}

}
