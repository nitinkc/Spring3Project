package com.spring.training.spring3to5.com.app.l9Annotations;

import com.spring.training.spring3to5.beans.b9Annotation.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T15QualifierAnno {
	/* Autowired Annotation go for "byType" first, if there are multiple beans
	 * of same type then it goes byName*/
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"x9QualifierAnno.xml");

		Triangle t = (Triangle) context.getBean("nitin");
		System.out.println(t);
		
		/* Example of Alias*/
		Triangle t2 = (Triangle) context.getBean("triangle-alias");
		System.out.println(t2);
	}
}
