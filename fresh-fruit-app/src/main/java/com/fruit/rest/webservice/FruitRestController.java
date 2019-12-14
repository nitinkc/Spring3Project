package com.fruit.rest.webservice;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fresh.fruit.constant.FruitAppURI;
import com.fruit.controller.model.FruitForm;
import com.fruit.controller.model.FruitList;
import com.fruit.controller.model.FruitPaginationForm;
import com.fruit.service.FruitService;
import com.fruit.sorter.SortByPriceDesc;

@Controller
@Scope("request") //singleton , prototype ,request ,session , gloabal session
//JSP/Servlet - >>>>>>>request , session , application , page
public class FruitRestController {
	
	@Autowired
	@Qualifier("IFruitService")
	private FruitService fruitService;
	
	//http://localhost:5050/fresh-fruit-app/rest/message
	@RequestMapping(value=FruitAppURI.MESSAGE,method=RequestMethod.GET)
	@ResponseBody public String message() {
		return "I love spring rest!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"; //    /I love spring rest!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!.jsp
	}
	
	@RequestMapping(value="fruitWithPaginationAjax.do",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public FruitPaginationForm fruitWithPagination(@RequestParam(value="page",required=false) String  page) {
		int recordsPerPage=3;
		int currentPage=0;
		if(page==null) {
			currentPage=1;
		}else{
			currentPage=Integer.parseInt(page);
		}
		FruitPaginationForm fruitPaginationForm = fruitService.findFruitsWithPagination( (currentPage-1)*recordsPerPage, recordsPerPage);
		fruitPaginationForm.setCurrentPage(currentPage);
		fruitPaginationForm.initPagination(); //initializing number of total pages......
		//model.addAttribute("fruitPaginationForm", fruitPaginationForm);
		return fruitPaginationForm; 
	}
	
	
	//Narrowing the resource
	@RequestMapping(value=FruitAppURI.SORT_FRUIT_BY_PRICE,method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public List<FruitForm> sortFruitByPrice(@PathVariable("porder") String orderBy,@RequestParam("pcity") String pcity) {
		List<FruitForm>  fruitForms=null;
		if("All".equalsIgnoreCase(pcity)) {
			  fruitForms=fruitService.findFruits();
		}else{
			  fruitForms=fruitService.findFruitsByCity(pcity);	
		}
		if(orderBy.equalsIgnoreCase("asc")) {
			Collections.sort(fruitForms);
		}else{
			Collections.sort(fruitForms,new SortByPriceDesc() );
		}
		return fruitForms;
	}
	
	
	//Narrowing the resource
	@RequestMapping(value=FruitAppURI.FIND_ALL_FRUITS,method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public FruitList showFruits() {
		FruitList fruitList=new FruitList();
		List<FruitForm>  fruitForms=fruitService.findFruits();
		fruitList.setFruitForms(fruitForms);
		return fruitList;
	}
	
	//Narrowing the resource
	@RequestMapping(value=FruitAppURI.FIND_ALL_FRUITS_AS_XML,method=RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE,MediaType.TEXT_XML_VALUE})
	@ResponseBody public FruitList showFruitsAsXML() {
		FruitList fruitList=new FruitList();
		List<FruitForm>  fruitForms=fruitService.findFruits();
		fruitList.setFruitForms(fruitForms);
		return fruitList;
	}
	
	//Narrowing the resource
	@RequestMapping(value=FruitAppURI.FIND_ALL_FRUITS_BY_SEARCH,method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public 	List<FruitForm>  showFruitsBySearch(@RequestParam("searchword") String searchword) {
		List<FruitForm>  fruitForms=null;
	    fruitForms=fruitService.findFruitsByCity(searchword);	
		return fruitForms;
	}
	
	
	//Narrowing the resource
	@RequestMapping(value=FruitAppURI.FIND_ALL_FRUITS_BY_CITY,method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public 	List<FruitForm>  showFruitsByCity(@RequestParam("pcity") String pcity) {
		List<FruitForm>  fruitForms=null;
		if("All".equalsIgnoreCase(pcity)) {
			  fruitForms=fruitService.findFruits();
		}else{
			  fruitForms=fruitService.findFruitsByCity(pcity);	
		}
		return fruitForms;
	}
	
	//sending data as a part of URI
	//http://localhost:5050/fresh-fruit-app/rest/fruit/2
	@RequestMapping(value=FruitAppURI.DELETE_FRUIT_BY_FID,method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public List<FruitForm> deleteFruit(@PathVariable("fid") String fid) {
		String result=fruitService.deleteFruitByFid(fid);
		List<FruitForm> fruitForms=null;
		if("deleted".equals(result)){
			fruitForms=fruitService.findFruits();	
		}
		return fruitForms; //give view name with out extension........../fruitSearch.jsp
	}
	
	@RequestMapping(value=FruitAppURI.ADD_UPDATE_FRUIT,method=RequestMethod.POST,
			produces={MediaType.APPLICATION_JSON_VALUE},
			consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public String uploadFruit(@RequestBody FruitForm fform) {
		fruitService.addUpdateFruit(fform);
		return "Hey user you fruit detail is uploded successfully!!!!!"; //give view name with out extension........../fruitSearch.jsp
	}
	
	@RequestMapping(value=FruitAppURI.ADD_UPDATE_FRUIT,method=RequestMethod.PUT,
			produces={MediaType.APPLICATION_JSON_VALUE},
			consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public String updateFruit(@RequestBody FruitForm fform) {
		String result=fruitService.addUpdateFruit(fform);
		return "Hey user you fruit detail is uploded successfully!!!!!"; //give view name with out extension........../fruitSearch.jsp
	}
	
	
	@RequestMapping(value="fruit/temp",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public FruitForm testData() {
		   FruitForm form=new FruitForm();
		   form.setName("chiily");
		   form.setPcity("MAjs");
		   form.setPrice(122);
		   form.setQuantity(122);
		   form.setTaste("bitter");
		   return form;
	}

}
