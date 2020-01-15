package com.spring.training.spring3to5.beans.b10LifeCycle;

import javax.annotation.Resource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Square implements InitializingBean, DisposableBean {
	
	@Resource(name="A")
	private Point A;
	@Resource(name="pointB")
	private Point B;
	@Resource(name="pointC")
	private Point C;
	@Resource(name="pointD")
	private Point D;
	
	@Override
	//Coming from InitializingBean Interface
	public void afterPropertiesSet() throws Exception {
		System.out.println("After PropertiesSet invoked in Square...");
	}

	@Override
	// Coming from DisposableBean Interface
	public void destroy() throws Exception {
		System.out.println("After Destroy invoked of Square...");
	}
	
	/* To be invoked in Case two with beans (attribute oif the bean) */
	public void squareInit(){
		System.out.println("Custom Square init Invoked (Defined as the attribute of the bean element");
	}
	
	public void squareDestroy(){
		System.out.println("Custom Sea destroy Invoked (Defined as the attribute of the bean element)");
	}
	
	/* To be initialized with the default methods*/
	public void squareDefaultInit(){
		System.out.println("Default Square init Invoked (Defined in the "
				+ "default-init-method=\"squareInit\") in the XML config!!!");
	}
	
	public void squareDefaultDestroy(){
		System.out.println("Custom Sea destroy Invoked (Defined in the "
				+ "default-destroy-method=\"squareDestroy\") int the XML Config!!!");
	}
	
	public String toString(){
		return (A + ", " + B + 
				", " + C + ", " + D);
	}
	
	public Point getA() {
		return A;
	}
	public void setA(Point a) {
		A = a;
	}
	public Point getB() {
		return B;
	}
	public void setB(Point b) {
		B = b;
	}
	public Point getC() {
		return C;
	}
	public void setC(Point c) {
		C = c;
	}
	public Point getD() {
		return D;
	}
	public void setD(Point d) {
		D = d;
	}	
}
