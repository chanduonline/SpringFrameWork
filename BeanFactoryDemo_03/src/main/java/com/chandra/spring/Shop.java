package com.chandra.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Shop {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("G:\\NewJ_SpringFramework_22nd\\BeanFactoryDemo_03\\src\\main\\resources\\spring.xml"));
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Spring Configuration file Loaded....");
		Product p = factory.getBean("product",Product.class);
		p.productDetails();
	

	}

}
