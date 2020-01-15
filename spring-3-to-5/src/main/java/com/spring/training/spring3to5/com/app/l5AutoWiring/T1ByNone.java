package com.spring.training.spring3to5.com.app.l5AutoWiring;

import com.spring.training.spring3to5.beans.b5autowiringBeans.C2Line;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T1ByNone {
	
	/* 5 Auto-wiring modes are supported
	 * 1. none - set it manually via ref. attribute
	 * 2. byName -  auto-wiring by property name: The name of the bean is same 
	 * 		that of the other bean property
	 * 3. byType - auto-wiring by property data type. if the data type of a 
	 * 		bean is compatible with data type of other bean
	 * 4. constructor - by type mode in constructor argument
	 * 5. auto-detect - if default constructor is found, use auto wired 
	 * 		constructor, else use auto-wire by type
	 *   
	 * NOTE: It is always a good practise to combine both "auto-wire" and 
	 * dependency-check="object"
	 * 
	 * ALSO: auto wiring make development faster with great costs- adds complexity 
	 * to entire bean configuration file
	 * */

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("b2autoWiringTest.xml");
		
		C2Line c = (C2Line) context.getBean("line0");
		
		c.draw();
		System.out.println(c.getEnd());

	}

}
