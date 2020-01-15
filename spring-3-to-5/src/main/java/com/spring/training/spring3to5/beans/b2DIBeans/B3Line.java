package com.spring.training.spring3to5.beans.b2DIBeans;

// A line is defined with two points 
public class B3Line {
	private B2Point start;
	private B2Point end;
	
	public void draw(){
		System.out.println("The line created");
		System.out.println("Point A is (" + this.start.getX() +","+this.start.getY() +")");
		System.out.println("Point B is (" + this.end.getX() +","+this.end.getY() +")");

	}
	
	public B2Point getStart() {
		return start;
	}
	public void setStart(B2Point start) {
		this.start = start;
	}
	public B2Point getEnd() {
		return end;
	}
	public void setEnd(B2Point end) {
		this.end = end;
	}
}
