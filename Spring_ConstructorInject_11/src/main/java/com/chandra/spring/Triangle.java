package com.chandra.spring;

public class Triangle {
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Triangle(Point pointA, Point pointB, Point pointC) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}
	
	public void draw()
	{
		System.out.println("PointA = ("+pointA.x+","+pointA.y+")");
		System.out.println("PointB = ("+pointB.x+","+pointB.y+")");
		System.out.println("PointC = ("+pointC.x+","+pointC.y+")");
	}
	

}
