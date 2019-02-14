package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends GenericServlet {

	private static final long serialVersionUID = 4816592117303807796L;
	
	private final static Logger logger = Logger.getLogger(HelloServlet.class);

	static int requests = 0;
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException
	{
		logger.trace("Servicing request");
		
		String context = getServletContext().getInitParameter("envVar");
		String config = getServletContext().getInitParameter("secret");
		
		String text = "<h1>Hello! I see you have made it!</h1>"
				+ "<br>This is a response from our generic servlet!"
				+ "<br><hr><br><li> Request #: " + ++requests
				+ "<li> Servlet Context: " + context
				+ "<li> Servlet Config: " + config;

		res.setContentType("text/html");
		
		PrintWriter writer = res.getWriter();
		
		
		writer.write(text);
	}

}