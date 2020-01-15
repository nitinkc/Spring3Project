package com.spring.training.spring3to5.beans.b1basicBeans;

public class ReferenceLocal {
	
	private String str;
	
	public void sayHi(String str){
		System.out.println("Coming from Reference Local : " + str);
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	

}
