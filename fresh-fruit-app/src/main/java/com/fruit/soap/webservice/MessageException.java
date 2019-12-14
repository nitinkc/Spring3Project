package com.fruit.soap.webservice;

/**
 * 
 * @author nagendra.yadav
 *
 */
public class MessageException  extends Exception {
	
	private MessageDetail fault;
	
    public MessageException(String message) {
        super(message);
    }

    public MessageException(String message, MessageDetail fault) {
        super(message);
        this.fault=fault;
    }
    
    public MessageDetail getFault(){
    	return fault;
    }
}
