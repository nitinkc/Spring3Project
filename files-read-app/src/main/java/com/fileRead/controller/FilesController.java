package com.fileRead.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FilesController {
	
	@RequestMapping(value="getFile.do",method=RequestMethod.POST)
	// model to send the data
	public String fileShowController(HttpServletRequest req, Model model){
		
		// not getAttribute (See servlet lectures)
		String fileName = req.getParameter("fileName");
		
		System.out.println(fileName);
		
		return "index"; 
		
	}
	
	// Read the data from the html/jsp
	
	
	//retiurn the path of the file

}
