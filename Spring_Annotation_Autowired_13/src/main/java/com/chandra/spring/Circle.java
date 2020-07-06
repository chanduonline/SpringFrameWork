package com.chandra.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle {
	
	private Point point;

	@Autowired
	@Qualifier("point3")
	public void setPoint(Point point) {
		this.point = point;
	}
	
	public void draw()
	{
		System.out.println("Circle = ("+point.getX()+","+point.getY()+")");
	}

}
