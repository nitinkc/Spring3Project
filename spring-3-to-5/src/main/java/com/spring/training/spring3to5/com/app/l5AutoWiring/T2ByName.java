package com.spring.training.spring3to5.com.app.l5AutoWiring;

import com.spring.training.spring3to5.beans.b5autowiringBeans.C2Line;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T2ByName {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"b2autoWiringTest.xml");

		C2Line line = (C2Line) context.getBean("line1");
		line.draw();
	}
}
