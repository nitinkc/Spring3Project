package com.spring.training.spring3to5.beans.b11Stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class State {
	@Autowired
	private City bigCity;
	@Autowired
	private City smallCity;
	
	@Override
	public String toString(){
		return ("Big City: " + bigCity + " , Small City: " + smallCity );
	}
	
	public City getBigCity() {
		return bigCity;
	}
	public void setBigCity(City bigCity) {
		this.bigCity = bigCity;
	}
	public City getSmallCity() {
		return smallCity;
	}
	public void setSmallCity(City smallCity) {
		this.smallCity = smallCity;
	}
}
