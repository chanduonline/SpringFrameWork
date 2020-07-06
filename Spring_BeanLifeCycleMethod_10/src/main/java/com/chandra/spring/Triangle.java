package com.chandra.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle implements InitializingBean,DisposableBean{
	
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	public void draw()
	{
		System.out.println("Triangle type : "+name);
	}

	public void destroy() throws Exception {
		System.out.println("Interface destroy method");
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Interface init method");
		
	}
	
	public void myInitMethod()
	{
		System.out.println("Our own init method");
	}
	public void cleanUp()
	{
		System.out.println("Our own destroy method");
	}

}
