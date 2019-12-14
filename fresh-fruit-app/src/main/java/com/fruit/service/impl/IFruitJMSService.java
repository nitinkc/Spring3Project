/*package com.fruit.service.impl;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.stereotype.Service;

import com.fresh.fruit.vo.FruitVO;
import com.fruit.service.FruitJMSService;

@Service("IFruitJMSService")
public class IFruitJMSService implements FruitJMSService {
	
	  public String addFruit(FruitVO fruitVO) {
		  //JMS Sender code to send message to JMS MOM /queue
		  //Point JNDI running on server
	        Properties props = new Properties();
	        props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
	        props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
	        //1099 JNDI port of JBOSS
	        props.setProperty("java.naming.provider.url", "localhost:1099");
	      //here we are reaching to the JNDI
	        ConnectionFactory cf = null;
	        Connection connection =  null;
	        try {
	        	    //using below context object we can talk with JNDI
	        		Context context = new InitialContext(props);
	        		cf = (ConnectionFactory)context.lookup("/ConnectionFactory");
	        		connection = cf.createConnection();
	        		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        		
	        		Queue queue = (Queue)context.lookup("/queue/orderMessage");
	        		//Here we are creating producer using session + Queue
	        		MessageProducer publisher = session.createProducer(queue);
	        		
	        		//wrapping my java object into JMS API which ObjectMessage
	        		ObjectMessage objectMessage=session.createObjectMessage();
	   			    objectMessage.setObject(fruitVO);
	        	 	//sending Message to JMS queue using MessageProducer
	   			   publisher.send(objectMessage);
	   			   System.out.println("__@_@_@_Message is send to JMS queue..........queue/orderMessage "+fruitVO);
	        		
	        }catch(Exception exe) {
	        	exe.printStackTrace();
	        }finally{
	        	if(connection!=null){
	        		try {
						connection.close();
					} catch (JMSException e) {
						e.printStackTrace();
					}
	        	}
	        }
		  return "Order is placed to MOM!!!!!!!!!!!!!!!!";
	  }


}
*/