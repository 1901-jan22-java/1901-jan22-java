/*package com.revature.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("*.view")
public class LoadViewsServlet {
	private static Logger log = Logger.getLogger(LoadViewsServlet.class;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		String resourcePath = "partials/" + process(req,resp) + ".html";
		log.info(resourcePath);
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}
}*/
