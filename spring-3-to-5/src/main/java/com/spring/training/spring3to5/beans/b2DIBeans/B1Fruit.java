package com.spring.training.spring3to5.beans.b2DIBeans;

public class B1Fruit {
	private String name;
	private String season;
	private int id;

	B1Fruit(String name, String season, int id){
		// Is equivalent to this.name = name;
		this.setName(name);
		this.setSeason(season);
		this.setId(id);
	}
	
	/* Intentional constructor to confuse Spring*/
	B1Fruit(int id, String name, String season){
		this.setName(name);
		this.setSeason(season);
		this.setId(id);
	}
	
	//Default fruit is Mango
	B1Fruit(){
		this.name = "Mango";
		this.season = "Summer";
		this.id = 56789;
	}
	
	public void fruitTest(){
		System.out.println("Greeting from Fruit");
		System.out.println("I am " + this.name + "( ID# " + this.id + " ) and I can be found in " + this.season);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
