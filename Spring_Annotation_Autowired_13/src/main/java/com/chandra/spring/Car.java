package com.chandra.spring;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class Car {
    
	private String color;
	
	@Required
	@Value("Blue")
	public void setColor(String color) {
		this.color = color;
	}
	
	public void carColor()
	{
		System.out.println("Your Car Color : "+color);
	}
	
}
