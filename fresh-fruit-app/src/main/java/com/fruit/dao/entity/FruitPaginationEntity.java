package com.fruit.dao.entity;

import java.util.List;

/**
 * 
 * @author AAAAAAA
 * 
 */
public class FruitPaginationEntity {
	
	private int noOfRecords;
	private List<FruitEntity> fruitEntityList;

	public int getNoOfRecords() {
		return noOfRecords;
	}

	public void setNoOfRecords(int noOfRecords) {
		this.noOfRecords = noOfRecords;
	}

	public List<FruitEntity> getFruitEntityList() {
		return fruitEntityList;
	}

	public void setFruitEntityList(List<FruitEntity> fruitEntityList) {
		this.fruitEntityList = fruitEntityList;
	}

	@Override
	public String toString() {
		return "FruitPaginationEntity [noOfRecords=" + noOfRecords
				+ ", fruitEntityList=" + fruitEntityList + "]";
	}

}
