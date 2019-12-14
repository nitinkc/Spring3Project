package com.fruit.rest.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GFruitExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(FruitException.class)
	@ResponseBody FruitErrorMessage handleLanguageException(HttpServletRequest req, Exception ex) {
		FruitErrorMessage fruitErrorMessage=new FruitErrorMessage("6000", ex.getMessage(), ex.getClass().toString(), req.getRequestURL().toString());
		return fruitErrorMessage;
	} 
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	@ResponseBody FruitErrorMessage applicationErrorMessage(HttpServletRequest req, Exception ex) {
		FruitErrorMessage fruitErrorMessage=new FruitErrorMessage("6000", ex.getMessage(), ex.getClass().toString(), req.getRequestURL().toString());
		return fruitErrorMessage;
	} 
	

}
