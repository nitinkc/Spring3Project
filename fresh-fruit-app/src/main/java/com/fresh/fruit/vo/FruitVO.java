
package com.fresh.fruit.vo;
import java.io.Serializable;

/**
 * 
 * @author jms boss
 *  
 */
public class FruitVO implements Serializable{

	private int sno;
	private String name;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "FruitVO [sno=" + sno + ", name=" + name + ", price=" + price
				+ ", taste=" + taste + ", quantity=" + quantity + ", pcity="
				+ pcity +  "]";
	}

}
