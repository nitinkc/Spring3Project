package com.spring.training.spring3to5.com.app.l10LifeCycle;

import com.spring.training.spring3to5.beans.b10LifeCycle.Rectangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T16LifeCycleMethods {

	public static void main(String[] args) {
				
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"x10LifeCycleAnno.xml");

		// Calling the bean by the name of the Alias
		Rectangle r = (Rectangle) context.getBean("nitin");
		System.out.println(r);
	}
}