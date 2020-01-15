package com.spring.training.spring3to5.com.app.l9Annotations;

import com.spring.training.spring3to5.beans.b9Annotation.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T13RequiredAnno {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("b1ApplnContextTest.xml");
		
		Circle c = (Circle)context.getBean("circle");
		System.out.println(c);
		
		
	}

}
