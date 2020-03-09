package com.fruit.controller.model;

import java.util.List;

public class
FruitPaginationForm {

	private int currentPage;
	private int noOfRecords;
	private List<FruitForm> fruitFormList;
	private int recordsPerPage=3;
	private int noOfPages;
	
	public void initPagination(){
		noOfPages=(int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}

	public void setNoOfRecords(int noOfRecords) {
		this.noOfRecords = noOfRecords;
	}

	public List<FruitForm> getFruitFormList() {
		return fruitFormList;
	}

	public void setFruitFormList(List<FruitForm> fruitFormList) {
		this.fruitFormList = fruitFormList;
	}

	@Override
	public String toString() {
		return "FruitPaginationForm [noOfRecords=" + noOfRecords
				+ ", fruitFormList=" + fruitFormList + "]";
	}

}
