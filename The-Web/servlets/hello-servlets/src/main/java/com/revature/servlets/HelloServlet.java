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

/**
 * @author Genesis
 *
 */
public class HelloServlet extends GenericServlet {


	private static final long serialVersionUID = -5429702260507628282L;

	private static Logger log = Logger.getLogger(HelloServlet.class);
	
	/*
	 * First method of servlet lifecycle 
	 * here is where we initialize the servlet, potentially with 
	 * servlet variables or special logging functionality
	 * should always call super.init() first 
	 * 
	 * this init method is called by default before 
	 * the first request to this servlet, however with the 
	 * <load-on-startup> tag (or property if using annotations), we
	 * can configure our servlets to be initialized upon startup 
	 * of our container (Tomcat)
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		log.trace("Initializing HelloServlet");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		log.trace("Servicing requests to HelloWorld");
		//SERVICE METHOD INSIDE OF A GENERICSERVLET MUST BE OVERRIDEN
		
		String text = "HELLO WORLD! This is a response from our generic servlet!";
		
		//PrintWriter - used to write text responses 
		PrintWriter writer = res.getWriter();
		
		writer.write(text);
		
	}
	
	/*
	 * last method in the servlet lifecycle, this deallocates 
	 * memory from the servlet
	 */
	@Override
	public void destroy() {
		super.destroy();
		log.trace("Destroying Helloi World");
	}

}
