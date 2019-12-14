package com.fruit.controller.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FruitList {
	private List<FruitForm> fruitForms;

	public List<FruitForm> getFruitForms() {
		return fruitForms;
	}

	public void setFruitForms(List<FruitForm> fruitForms) {
		this.fruitForms = fruitForms;
	}

	@Override
	public String toString() {
		return "FruitList [fruitForms=" + fruitForms + "]";
	}

}
