package com.spring.training.spring3to5.com.app.l12PostProcessor;

import com.spring.training.spring3to5.beans.b9Annotation.Line;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T19PreprocessorTester {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("x12PostProcessor.xml");
		Line line = context.getBean("line", Line.class);
		System.out.println(line);
		
	}
}
