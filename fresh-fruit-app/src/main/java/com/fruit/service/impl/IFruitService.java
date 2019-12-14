package com.fruit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fresh.fruit.vo.FruitVO;
import com.fruit.controller.model.FruitForm;
import com.fruit.controller.model.FruitPaginationForm;
import com.fruit.dao.entity.FruitEntity;
import com.fruit.dao.entity.FruitPaginationEntity;
import com.fruit.dao.impl.IFruitDao;
import com.fruit.service.FruitService;

@Service("IFruitService")
public class IFruitService implements FruitService {
	
	@Autowired
	@Qualifier("IFruitDao")
	private IFruitDao fruitDao;
	
/*	@Autowired
	@Qualifier("IFruitJMSService")
	private FruitJMSService fruitJMSService;
	*/
	
	  public String addUpdateFruit(FruitForm fruitForm) {
		  ////////JMS//////////
		  FruitVO fruitVO=new FruitVO();
		  BeanUtils.copyProperties(fruitForm, fruitVO);
		 // fruitJMSService.addFruit(fruitVO);
		  //////////////////////////////
		  FruitEntity entity=new FruitEntity();
		  BeanUtils.copyProperties(fruitForm, entity);
		  String result=fruitDao.addUpdateFruit(entity);
		  return result;
	  }

	@Override
	public List<FruitForm> findFruits() {
		List<FruitForm> fruitFormList=new ArrayList<FruitForm>();
		List<FruitEntity> fruitEntities=fruitDao.findFruits();
		for(FruitEntity fe:fruitEntities){
			FruitForm form=new FruitForm();
			  BeanUtils.copyProperties(fe, form);
			  fruitFormList.add(form);
		}
		return fruitFormList;
	}
	
	  @Override
	   public byte[] findImageByFid(String fid){
		   return fruitDao.findImageByFid(fid);
	   }
	  
	  @Override
	  public String deleteFruitByFid(String fid) {
		  return fruitDao.deleteFruitByFid(fid);
	  }
	  
	  
	  @Override
	  public FruitForm findFruitByFid(String fid) {
		  FruitEntity entity=fruitDao.findFruitByFid(fid);
		  FruitForm fruitForm=new FruitForm();
		  BeanUtils.copyProperties(entity, fruitForm);
		  return fruitForm;
	  }

	@Override
	public List<String> findAllCity() {
		return fruitDao.findAllCity();
	}
	


	@Override
	public List<FruitForm> findFruitsByCity(String pcity) {
		List<FruitForm> fruitFormList=new ArrayList<FruitForm>();
		List<FruitEntity> fruitEntities=fruitDao.findFruitsByCity(pcity);
		for(FruitEntity fe:fruitEntities){
			FruitForm form=new FruitForm();
			  BeanUtils.copyProperties(fe, form);
			  fruitFormList.add(form);
		}
		return fruitFormList;
	}

	@Override
	public FruitPaginationForm findFruitsWithPagination(int start,
			int noOfRecords) {
		
		FruitPaginationEntity fruitPaginationEntity=fruitDao.findFruitsWithPagination(start, noOfRecords);
		FruitPaginationForm fruitPaginationForm=new FruitPaginationForm();
		BeanUtils.copyProperties(fruitPaginationEntity, fruitPaginationForm);
		
		List<FruitForm> fruitFormList=new ArrayList<FruitForm>();
		List<FruitEntity> fruitEntities=fruitPaginationEntity.getFruitEntityList();
		for(FruitEntity fe:fruitEntities){
		  	FruitForm form=new FruitForm();
			  BeanUtils.copyProperties(fe, form);
			  fruitFormList.add(form);
		}
		fruitPaginationForm.setFruitFormList(fruitFormList);
		return fruitPaginationForm;
	}

}
