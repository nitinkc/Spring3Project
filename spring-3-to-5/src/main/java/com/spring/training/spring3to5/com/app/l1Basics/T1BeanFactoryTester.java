package com.spring.training.spring3to5.com.app.l1Basics;

import com.spring.training.spring3to5.beans.b1basicBeans.B1Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class T1BeanFactoryTester {

	/* Spring Container are of two types.
	 * org.springframework.beans &
	 * org.springframework.context
	 * 
	 * This is an example implementing BeanFactory
	 * For Bean Factory, the XML needs be in the root directory
	 * */
	public static void main(String[] args) {
	
		/* FileSystemResource is to load a file from FileSystem*/
		//Can also give fully qualified path. By default it picks up from the Eclipse project root dir.
		BeanFactory beanFactory=new XmlBeanFactory(new FileSystemResource("beanFactoryTest.xml"));
		
		// Instantiating without B1Triangle triangle = new B1Triangle();
		// beanFactory returna an Object!!
		B1Triangle triangle=(B1Triangle) beanFactory.getBean("triangle");

		triangle.setSide(20);
		triangle.setName("Equilateral");
		triangle.greetings();
		System.out.println("The set dimentions for the " + triangle.getName() +
				" triangle is "+ triangle.getSide());
	}

}
