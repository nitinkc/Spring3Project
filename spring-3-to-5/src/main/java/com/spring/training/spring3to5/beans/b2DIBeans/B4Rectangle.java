package com.spring.training.spring3to5.beans.b2DIBeans;

import java.util.ArrayList;
import java.util.List;

public class B4Rectangle {
	private List<B2Point> point = new ArrayList<B2Point>();
	
	public void draw(){
		System.out.println("Rectangle drawn !!!");
		for (B2Point points:point) {
			System.out.println("Coordinate is : ("+points.getX()+" , "+points.getY()+")");
		}
	}

	public List<B2Point> getPoint() {
		return point;
	}

	public void setPoint(List<B2Point> point) {
		this.point = point;
	}

}
