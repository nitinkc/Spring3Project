package com.pack.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NameServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Name Servlet invoked...");
		
		String un = request.getParameter("userName");
		System.out.println("User Name is : " + un);
		
		PrintWriter san=response.getWriter();
		san.println("<h1>User Name is : " + un+"</h1>");
		
		//<input type="text" name="" value="'+un+'">
		
		//generates the request for WelcomeServlet.java
		RequestDispatcher rd=request.getRequestDispatcher("welcome");
		//forwards the ctrl to WelcomeServlet.java & also forwards the parameters with
		//current request

		//this forward() method will send the current page(i.e. NameServlet) request & response 
		// to next page (i.e.WelcomeServlet)
		
		//rd.forward(request, response);
		
		//include() inlcudes the content(response of other resource(i.e. WelcomeServlet))
		//on current page(i.e. Name Servlet)
		//rd.include(request, response);
		
		//this sendRedirect() method will not send the current page(i.e. NameServlet) request & response 
		// to next page (i.e.WelcomeServlet)
		response.sendRedirect("welcome");
		
		//san.print("<a href='welcome'>Welcome Servlet</a>");
	}
}