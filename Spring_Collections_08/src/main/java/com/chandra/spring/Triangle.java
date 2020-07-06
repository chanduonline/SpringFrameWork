package com.chandra.spring;

import java.util.List;

public class Triangle {

	private List<Point> points;

	
	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
	  for(Point p:points)
	  {
		  System.out.println("Point =("+p.getX()+","+p.getY()+")");
	  }
	}

}
