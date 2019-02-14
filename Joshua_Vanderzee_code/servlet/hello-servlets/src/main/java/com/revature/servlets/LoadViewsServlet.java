package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("*.view")
public class LoadViewsServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(LoadViewsServlet.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri[] = req.getRequestURI().split("/");
		String resource = uri[uri.length - 1];
		
		String resourcePath = "/partials/" + resource.substring(0, resource.length() - 5) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);		
		try {

		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}
		System.out.println(resourcePath);
	}
}
