package com.chandra.spring;

public class Triangle {
	
	private String name;

	//constructor Injection
	public Triangle(String name) {
		this.name = name;
	}
	
	public void draw()
	{
		System.out.println("Triangle Type : "+name);
	}

}
