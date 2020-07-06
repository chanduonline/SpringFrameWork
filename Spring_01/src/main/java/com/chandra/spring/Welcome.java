package com.chandra.spring;

public class Welcome {
	
	private String name;
	
	Welcome()
	{
		System.out.println("Welcome Object Created");
	}

    //setter Injection
	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello()
	{
		System.out.println("Welcome to Spring Framework Mr. "+name);
	}
	

}
