package com.fruit.controller.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class FruitForm implements Comparable<FruitForm> {
 
	private int sno; 
	private String name;
	@JsonProperty("price")
	private int price;
	private String taste;
	private int quantity;
	private String pcity;
	private byte[] image;

	public int getSno() {
		return sno;
	}



	public void setSno(int sno) {
		this.sno = sno;
	}



	public FruitForm(){
		
	}
	
	

	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public FruitForm(String name, int price, String taste, int quantity,
			String pcity) {
		super();
		this.name = name;
		this.price = price;
		this.taste = taste;
		this.quantity = quantity;
		this.pcity = pcity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPcity() {
		return pcity;
	}

	public void setPcity(String pcity) {
		this.pcity = pcity;
	}

	@Override
	public String toString() {
		return "FruitForm [name=" + name + ", price=" + price + ", taste="
				+ taste + ", quantity=" + quantity + ", pcity=" + pcity + "]";
	}

	@Override
	public int compareTo(FruitForm o) {
		int p=price-o.price;
		if(p==0) {
			  p=quantity-o.quantity;
		}
		return  p;
	}

}
