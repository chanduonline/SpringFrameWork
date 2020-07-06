package com.chandra.spring;

import org.springframework.stereotype.Component;

//@Component(value="helloObj")
public class Hello {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
