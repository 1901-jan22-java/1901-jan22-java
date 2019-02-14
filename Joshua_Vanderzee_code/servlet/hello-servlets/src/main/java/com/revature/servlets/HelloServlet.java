package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends GenericServlet {

	private static Logger log = Logger.getLogger(HelloServlet.class);
	
	static int count = 0;
	@Override
	public void init() throws ServletException {
		super.init();
		log.trace("Creating hello world");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		log.trace("Destroying Hello world");
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5429702260507628282L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//service method
		
		String context = getServletContext().getInitParameter("Env");
		String config = getServletConfig().getInitParameter("secert");
		String text = "<h1>Hello World from servlet"
				+ "<br>"
				+ "<br>Request # " + ++count + ""
						+ "Context " + context + "</h1>";
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		writer.write("Hello");
	}

}
