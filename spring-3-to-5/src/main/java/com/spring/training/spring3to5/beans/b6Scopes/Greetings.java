package com.spring.training.spring3to5.beans.b6Scopes;

public class Greetings {
	
	private String name;
	
	public void sayHi(){
		System.out.println("Hello from " + name + " From the class Greetings in the package b6Scopes beans");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
