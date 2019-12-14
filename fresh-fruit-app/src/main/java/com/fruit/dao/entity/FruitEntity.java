package com.fruit.dao.entity;

public class FruitEntity {

	private int sno; 
	private String name;
	private int price;
	private String taste;
	private int quantity;
	private String pcity;
	

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}


	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	
	public FruitEntity(){
		
	}

	public FruitEntity(String name, int price, String taste, int quantity,
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
		return "FruitEntity [name=" + name + ", price=" + price + ", taste="
				+ taste + ", quantity=" + quantity + ", pcity=" + pcity + "]";
	}

}
