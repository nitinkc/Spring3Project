package com.spring.training.spring3to5.beans.b8dependencyChecking;

public class Person {
	
	private String name;
	private String country;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString(){
		String ret = "The name of the Person is " + name + " from " + country; 
		return ret;
	}
}