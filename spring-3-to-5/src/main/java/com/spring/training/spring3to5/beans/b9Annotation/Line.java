package com.spring.training.spring3to5.beans.b9Annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Line {
	
	@Autowired
	private Point point1;
	@Autowired
	private Point point2;

	public String toString(){
		return ("Line Drawn from " + point1.toString() + ", " + point2.toString());
	}
	public Point getPointA() {
		return point1;
	}
	public void setPointA(Point pointA) {
		this.point1 = pointA;
	}
	public Point getPointB() {
		return point2;
	}
	public void setPointB(Point pointB) {
		this.point2 = pointB;
	}
}
