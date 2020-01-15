package com.spring.training.spring3to5.beans.b10LifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Rectangle {
	@Resource(name="A")
	private Point pointA;
	@Autowired
	private Point pointB;
	@Autowired
	private Point pointC;
	@Autowired
	private Point pointD;

	public String toString(){
		return (pointA + ", " + pointB + 
				", " + pointC + ", " + pointC);
	}
	
	/* Bean Life Cycle Destroy Execute */
	@PostConstruct
	public void RectangleInit(){
		System.out.println("In the Init Function of Rectangle...");
	}
	
	/* Bean Life Cycle Pre-Destroy */
	@PreDestroy
	public void RectangleDestroy(){
		System.out.println("In the Destroy Function of Rectangle...");
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
	public Point getPointD() {
		return pointD;
	}
	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}
}
