package com.fruit.soap.webservice;

import javax.jws.WebService;

@WebService
public class HelloWord {

	/**
	 * @param message
	 * @return
	 * @throws MessageException 
	 */
	public Welcome poke(String message) throws MessageException {
		if("I will kill you".equalsIgnoreCase(message)){
			MessageDetail detail=new MessageDetail();
			detail.setEcode("E3939");
			detail.setEmessage("Hey you cannot sent me this message");
			MessageException exception=new MessageException("Message is not correct!",detail);
			throw exception;
		}
		Welcome welcome=new Welcome();
		welcome.setMcode("2221");
		welcome.setMessage("Hey I am learning soap based web service!!!!!!!!!!!!!!!!!");
		return welcome;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	 public String oddEven(int p) {
		if(p%2==0) {
			return "This number "+p+" is even";
		}else{
			return "This number "+p+" is not even";
		}
	}
}
