 package com.fruit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.fruit.controller.model.FruitForm;
import com.fruit.controller.model.FruitPaginationForm;
import com.fruit.service.FactorialService;
import com.fruit.service.FruitService;

@Controller
public class FruitController {
	
	@Autowired
	@Qualifier("FactorialService")
	private FactorialService factorialService;
	
	@Autowired
	@Qualifier("IFruitService")
	private FruitService fruitService;
	
	public FruitController() {
		System.out.println("_@)))))))))))))))))))))))))))))))))))))");
		System.out.println("_@)))))))))))))))))))))))))))))))))))))");
		System.out.println("_@)))))))))))))))))))))))))))))))))))))");
		System.out.println("_@)))))))))))))))))))))))))))))))))))))");
		System.out.println("_@)))))))))))))))))))))))))))))))))))))");
	}
	
	@RequestMapping(value="findImageById.do",method=RequestMethod.GET)
	public void findImageById(HttpServletRequest req,HttpServletResponse response) {
		String fid=req.getParameter("fid");
		byte[] image=fruitService.findImageByFid(fid);
		//wrtting byte array into response
		ServletOutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(image);
			outputStream.flush();
		} catch (IOException e) {
		}
	}
	
	@RequestMapping(value="editFruitById.do",method=RequestMethod.GET)
	public String editFruitById(@RequestParam("fid") String fid,Model model) {
		FruitForm result=fruitService.findFruitByFid(fid);
		model.addAttribute("cform", result);
		return "fruitForm";
	}
		
	@RequestMapping(value="deleteFruitById.do",method=RequestMethod.GET)
	public String deleteFruitById(@RequestParam("fid") String fid,Model model) {
		String result=fruitService.deleteFruitByFid(fid);
		List<FruitForm>  fruitForms=fruitService.findFruits();
		model.addAttribute("fruitForms", fruitForms);
		model.addAttribute("result", result);
		return "fruits";
	}
	
	@RequestMapping(value="fruits.do",method=RequestMethod.GET)
	public String showFruits(Model model) {
		FruitForm fruitForm=new FruitForm();
		fruitForm.setPcity("All");
		model.addAttribute("fruitForm", fruitForm);
		List<FruitForm>  fruitForms=fruitService.findFruits();
		if(fruitForms!=null){
			Collections.sort(fruitForms);
		}
		model.addAttribute("fruitForms", fruitForms);
		return "fruits";
	}
	
	@RequestMapping(value="uploadFruit.do",method=RequestMethod.GET)
	public String getFruitPage(Model model) {
		FruitForm fruitForm=new FruitForm();
		model.addAttribute("cform", fruitForm);
		return "fruitForm";
		
	}
	
	@RequestMapping(value="fruitWithPagination.do",method=RequestMethod.GET)
	public String fruitWithPagination(@RequestParam(value="page",required=false)String  page,Model model) {
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
		model.addAttribute("fruitPaginationForm", fruitPaginationForm);
		return "tfruits"; //give view name with out extension........../fruitSearch.jsp
	}
	
	
	@RequestMapping(value="uploadFruit.do",method=RequestMethod.POST)
	public String uploadFruit(@ModelAttribute("cform") FruitForm fform,Model model) {
		fruitService.addUpdateFruit(fform);
		model.addAttribute("message", "Hey user you fruit detail is uploded successfully!!!!!");
		if(fform.getSno()!=0){
			return "redirect:/fruits.do";
		}
		return "fruitSuccess"; //give view name with out extension........../fruitSearch.jsp
	}
	
	@RequestMapping(value="fruitDetail.do",method=RequestMethod.POST)
	public String showDetail(HttpServletRequest request,Model model) {
		String fruitName=request.getParameter("fname");
		try {
				int num=Integer.parseInt(fruitName);
				int result=factorialService.factorial(num);
				model.addAttribute("result", result);
		}catch(NumberFormatException ex){
			model.addAttribute("result","Sorry Dear Fact is not computed because "+fruitName+" is not a number...");
		}
		fruitName="fruit/"+fruitName+".jpg";
		//Model - >>>just hash map which carry data from controller to view  -<>>same request scope
		model.addAttribute("pppppfruitName", fruitName);
		return "fruitSearch"; //give view name with out extension........../fruitSearch.jsp
	}
	
	@ModelAttribute("tasteList")
	public List<String> populateTaste(){
		List<String> tastsList=new ArrayList<String>();
		tastsList.add("Sour");
		tastsList.add("Sweet");
		tastsList.add("Bitter");
		tastsList.add("Pilsws");
		return tastsList;
	}
	
	@ModelAttribute("pcityList")
	public List<String> populatepcityList(HttpServletRequest req){
		List<String> pcityList=fruitService.findAllCity();
		return pcityList;
	}
	
	@ModelAttribute("quantityList")
	public List<String> populateQuantity(){
		List<String> quantityList=new ArrayList<String>();
		for(int i=0;i<30;i++) {
			quantityList.add(i+"");
		}
		return quantityList;
	}
	
	
	//It converts your upload file into byte array form after it
	//it is populated in customer java object
	@InitBinder
	  public void initBinder(WebDataBinder binder) {
	                   // to actually be able to convert Multipart instance to byte[]
	                   // we have to register a custom editor
	                   binder.registerCustomEditor(byte[].class,
	                                      new ByteArrayMultipartFileEditor());
	                   // now Spring knows how to handle multipart object and convert them
	  }	
}