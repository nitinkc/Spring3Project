package com.spring.training.spring3to5.com.app.l9Annotations;

import com.spring.training.spring3to5.beans.b9Annotation.Line;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T14AutowiredAnno {
	/* Autowired Annotation go for "byType" first, if there are multiple beans
	 * of same type then it goes byName*/
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"b1ApplnContextTest.xml");

		Line l = (Line) context.getBean("lineAnno");
		System.out.println(l);

	}
}
