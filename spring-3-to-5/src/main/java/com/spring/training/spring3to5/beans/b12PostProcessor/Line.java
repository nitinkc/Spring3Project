package com.spring.training.spring3to5.beans.b12PostProcessor;

import org.springframework.beans.factory.annotation.Autowired;

public class Line {
	
	@Autowired
	private Point pointA;
	@Autowired
	private Point pointB;

	public String toString(){
		return ("Line Drawn from " + pointA.toString() + " to " + pointB.toString());
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	
}
