package com.spring.training.spring3to5.com.app.l2DependencyInjection;

import com.spring.training.spring3to5.beans.b2DIBeans.B3Line;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T4ObjectInjection {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"b1ApplnContextTest.xml");
		B3Line line=(B3Line)context.getBean("line");
		
		// The ref tag in beans-> property, ref is the naem of the invokign tag
		/*Point pointA=new Point();
		pointA.setX(50);
		pointA.setY(100);
		
		Point pointB=new Point();
		pointB.setX(80);
		pointB.setY(900);
		
		Line line=new Line();
		line.setPointA(pointA);
		line.setPointB(pointB);*/
		
		line.draw();
	}

}
