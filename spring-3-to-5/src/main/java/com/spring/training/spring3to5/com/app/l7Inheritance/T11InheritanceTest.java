package com.spring.training.spring3to5.com.app.l7Inheritance;

import com.spring.training.spring3to5.beans.b7Inheritance.Customer;
import com.spring.training.spring3to5.beans.b7Inheritance.PersonAbstract;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T11InheritanceTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("b1ApplnContextTest.xml");
		
		// Calling the Child Customer bean (Will have the one property of the Parent)
		Customer c = (Customer) context.getBean("childCustomerBean");
		
		// The Country is set India in the Parent Class and is overridden to USA in the Child Class
		System.out.println(c);
		
		// Calling the "abstract=true" bean. There should be no property set
		// else there will be exception - BeanIsAbstractException
		// PersonAbstract pa = (PersonAbstract)context.getBean("abstractPersonBean");

		PersonAbstract pa1 = (PersonAbstract)context.getBean("abstractPersonBeanChild");
		System.out.println(pa1);
	}
}