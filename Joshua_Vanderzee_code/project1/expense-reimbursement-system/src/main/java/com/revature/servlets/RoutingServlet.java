package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/*")
public class RoutingServlet extends HttpServlet {
	Logger log = Logger.getLogger(RoutingServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri[] = req.getRequestURI().split("/");
		String resource = uri[uri.length - 1];
		log.info(resource);
		try {
			if (resource.contains(".view")) 
			{
				req.getRequestDispatcher(resource).forward(req, resp);
			}
		} catch (Exception e) {
			
			log.error(e);
			PrintWriter writer = resp.getWriter();
			//resp.setContentType("application/html");
			writer.write(e.getMessage());
			req.getRequestDispatcher("/partials/error.html").forward(req, resp);
		}

	}
}
