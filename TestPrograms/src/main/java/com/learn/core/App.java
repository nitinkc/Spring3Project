package com.learn.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.config.AppConfig;
import com.learn.hello.HelloWorld;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	 ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
 	    HelloWorld obj = (HelloWorld) context.getBean("helloBean");
 	    
 	    obj.greetings("Nitin");
    }
}
