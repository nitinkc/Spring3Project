package com.spring.training.spring3to5.com.app.l10LifeCycle;

import com.spring.training.spring3to5.beans.b10LifeCycle.Square;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T17LCMCase2{

	public static void main(String[] args) {
		
		// To invoke the DisposabelBean method, "AbstractApplicationContext"
		// has to be used along with calling the hook method
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"x10LCMCase1.xml");
		
		// Has to be done in order for it to work withAbstract Application Context 
		// ?? to call DisposableBean destroy
		context.registerShutdownHook();

		// Calling with the alias
		Square r = context.getBean("nitin", Square.class);
		System.out.println(r);
	}
}