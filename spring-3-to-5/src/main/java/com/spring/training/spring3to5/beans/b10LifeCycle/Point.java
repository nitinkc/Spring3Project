package com.spring.training.spring3to5.beans.b10LifeCycle;

public class Point {
	private int x;
	private int y;
	
	public String toString(){
		return ("[" + x + "," + y + "]");
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
