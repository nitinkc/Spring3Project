package com.spring.training.spring3to5.beans.b1basicBeans;

public class B1Triangle {
	
	private int side;
	private String name;
	
	//Default Constructor
	public B1Triangle(){
		
	}
	
	public B1Triangle(int side, String name){
		this.side = side;
		this.name = name;
		
		System.out.println(side + name);
	}
	
	//A method
	public void greetings(){
		System.out.println("Hello from the Triangle");
	}
	
	// Getters and Setters
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
