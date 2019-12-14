package com.pack.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	public void init(ServletConfig config) throws ServletException { // => ctrl+space
		System.out.println("init invoked !!!");
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("Service invoked !!!");
		System.out.println("Service invoked !!!");
		System.out.println("Service invoked !!!");
	}

	public void destroy() {
		System.out.println("destroy invoked !!!");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

}
