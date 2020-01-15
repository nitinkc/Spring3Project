package com.spring.training.spring3to5.com.app.l2DependencyInjection;

import com.spring.training.spring3to5.beans.b2DIBeans.B1Fruit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T3DIConstructorInjection {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"b1ApplnContextTest.xml");

		// Demonstration of Setting values through beans->constructor-arg value,index,type tag
		// "fruitConstructorInjection" will invoke the constructor of the Fruit class
		B1Fruit fruit = (B1Fruit) context.getBean("fruitConstructorInjection");
		
		/* The following will do the same thing as
		 * B1Fruit fruit = new B1Fruit("Kiwi", "Winter", 12);
		 */
		fruit.fruitTest();
		
		/* Constructor Ambiguity */
	}

}
