package com.spring.training.spring3to5.beans.b7Inheritance;

public class PersonAbstract {
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
		return "[name = " + name +
				", country = " + country + "]";
		
	}

}
