package com.spring.training.spring3to5.beans.b9Annotation;

import org.springframework.beans.factory.annotation.Required;

public class Circle {
	
	private Point center;
	private double radius;
	
	public String toString(){
		return ("Circle has the center at: " + 
					center.getX() +","+center.getY() );
	}
	public Point getCenter() {
		return center;
	}
	
	// Method level annotation
	@Required
	public void setCenter(Point center) {
		this.center = center;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	

}
