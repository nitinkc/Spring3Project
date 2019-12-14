package com.fruit.dao;

import java.util.List;

import com.fruit.dao.entity.FruitEntity;
import com.fruit.dao.entity.FruitPaginationEntity;

public interface FruitDao {
   public String addUpdateFruit(FruitEntity entity);
   public List<FruitEntity> findFruits();
   public List<String> findAllCity();
   public byte[] findImageByFid(String fid);
   public String deleteFruitByFid(String fid);
   public FruitEntity findFruitByFid(String fid);
   public List<FruitEntity> findFruitsByCity(String pcity);
   public FruitPaginationEntity findFruitsWithPagination(int start, int noOfRecords);
}
