package com.fruit.service;

import java.util.List;

import com.fruit.controller.model.FruitForm;
import com.fruit.controller.model.FruitPaginationForm;
import com.fruit.dao.entity.FruitPaginationEntity;

public interface FruitService {
	public List<FruitForm> findFruitsByCity(String pcity);
	public List<String> findAllCity() ;
	  public String addUpdateFruit(FruitForm fruitForm);
	 public List<FruitForm> findFruits() ;
	 public byte[] findImageByFid(String fid);
	 public String deleteFruitByFid(String fid);
	 public FruitForm findFruitByFid(String fid);
		public FruitPaginationForm findFruitsWithPagination(int start,
				int noOfRecords);

}