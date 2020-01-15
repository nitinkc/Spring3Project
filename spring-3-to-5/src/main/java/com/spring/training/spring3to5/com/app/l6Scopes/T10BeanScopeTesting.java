package com.spring.training.spring3to5.com.app.l6Scopes;

import com.spring.training.spring3to5.beans.b6Scopes.Greetings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* @Service and @Scope("prototype") annotations can also be used in the bean!!
 * */

public class T10BeanScopeTesting {
	public static void main(String[] args) {
		
		//instead of just passing one file, can pass multiple file
		ApplicationContext con = new ClassPathXmlApplicationContext(new String[] {"b1ApplnContextTest.xml"});
		
		Greetings greetA = (Greetings)con.getBean("scopeSingleton");
		greetA.setName("Nitin");
		greetA.sayHi();
		
		// Retrieve the bean again
		Greetings greetB = (Greetings)con.getBean("scopeSingleton");
		// The output of this is same as that of the Object greetA
		// The default Scoping is singleton
		greetB.sayHi();
		
		/* Prototype Scoping */
		Greetings greetC = (Greetings)con.getBean("scopePrototype");
		greetC.setName("NITIN CHAURASIA");
		greetC.sayHi();
		
		// Ny Setting the bean to Prototype, it creates a new instance everytime!!
		Greetings greetD = (Greetings)con.getBean("scopePrototype");
		greetD.sayHi();
		
		
	}

}
