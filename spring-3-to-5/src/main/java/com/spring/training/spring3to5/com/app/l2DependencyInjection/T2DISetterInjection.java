package com.spring.training.spring3to5.com.app.l2DependencyInjection;

import com.spring.training.spring3to5.beans.b2DIBeans.B1Fruit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T2DISetterInjection {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-All-Module.xml");

		// Demonstration of Setting values through beans->property, value tag
		// "fruitSetterInjection" will invoke the setters of the Fruit class
		B1Fruit fruit = (B1Fruit) context.getBean("fruitSetterInjection");

		/* The following will do the same thing as
		 * fruit.setName("Grapes"); fruit.setSeason("Winter);
		 */
		fruit.fruitTest();
	}

}
