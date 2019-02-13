/**
 * 
 */
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
	private static final long serialVersionUID = -5429702260507628282L;
	static int requestCount = 0;
	@Override
	public void init() throws ServletException {
		super.init();
		log.trace("Initializing HelloServlet");
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		log.trace("Servicing requests to HelloWorld");
		//Service Method inside of a generic servlet must be overriden. 
		
		//get servlet context and config info. 
		String context = getServletContext().getInitParameter("envVar");
		String config = getServletConfig().getInitParameter("secret");
		
		String text = "<h1>HELLO WORLD!</h1><br>THIS IS A RESPONSE FROM OUR GENERIC SERVLET!<br><hr><br><li>Request #" + ++requestCount + "<li>Servlet Context: " + context + "<li>Servlet Config: " + config;

		//PrintWriter object used to write text responses. 
		PrintWriter writer = res.getWriter();
		
		res.setContentType("text/html");
		writer.write(text);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		log.trace("Destroying HelloWorld");
	}
	
	
}
