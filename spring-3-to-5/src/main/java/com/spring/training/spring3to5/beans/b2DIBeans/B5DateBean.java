package com.spring.training.spring3to5.beans.b2DIBeans;

import java.sql.Date;

public class B5DateBean {
	
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString(){
		return "Date is: [ "+ date+" ]";
	}
}
