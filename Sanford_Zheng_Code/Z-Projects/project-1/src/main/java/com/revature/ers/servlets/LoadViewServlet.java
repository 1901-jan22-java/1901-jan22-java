package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3014802713949514627L;
	private static final Logger log = Logger.getLogger(LoadViewServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "html/" + process(req, resp) + ".html";

		log.trace("REQUEST URI: " + req.getRequestURI());
		log.trace("PROCESSED: " + resourcePath);
		
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}
	
	private String process(HttpServletRequest req, HttpServletResponse resp) {
		for(String r: req.getRequestURI().split("/")) {
			if(r.contains(".view")) {
				return r.substring(0, r.length()-5);
			}
		}
		return null;
	}
	
}
