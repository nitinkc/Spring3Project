package com.spring.training.spring3to5.beans.b11Stereotype;


public class City {
	private String name;
	private int zip;
	
	//Spill-your-guts-method
	public String toString(){
		return ("[" + name + " - " + zip + "]");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
}
