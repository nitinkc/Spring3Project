package com.spring.training.spring3to5.beans.b9Annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Triangle {
	
	/* Combination of Autowired and Qualifier
	 * can be replaced with the Resource Annotation
	 * */
	//@Autowired
	//@Qualifier(value="A")
	//@Qualifier(value="VertexA")
	@Resource(name="VertexA")
	private Point pointA;
	@Autowired
	private Point pointB;
	@Autowired
	private Point pointC;
	
	public String toString(){
		return ( pointA + ", " + pointB + ", " + pointC );
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
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
}
