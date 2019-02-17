package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("*.view")
public class LoadViewsServlet extends HttpServlet{
<<<<<<< HEAD
	
	private static final long serialVersionUID = 5788439482292060664L;
	
	private static Logger log = Logger.getLogger(LoadViewsServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "partials/" + process(req, resp) + ".html";
		log.info(resourcePath);
		log.info("Load View Request Sent To: " + req.getRequestURI());
		req.getRequestDispatcher(resourcePath).forward(req,  resp);
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		String[] uri = req.getRequestURI().split("/");
		String resource = uri[uri.length-1];
		return resource.substring(0, resource.length()-5);
	}
=======

	private static final long serialVersionUID = 5788439482292060664L;
	private static Logger log  = Logger.getLogger(LoadViewsServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] uri = req.getRequestURI().split("/");
		String resource = uri[uri.length-1];
		
		String resourcePath = "partials/" + 
			resource.substring(0, resource.length()-5) +".html";
		log.info(resourcePath);
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		req.getRequestDispatcher(resourcePath).forward(req, resp); 
		
	}
	
>>>>>>> master
}
