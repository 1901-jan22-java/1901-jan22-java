package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.users.User;

@WebServlet("*.view")
public class LoadViewServlets extends HttpServlet {
	public static Logger log = Logger.getLogger(LoadViewServlets.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		String resourcePath = "views/" + process(req,resp) + ".html";
		log.debug("This is the resource path: " + resourcePath + user);
		if(resourcePath.equalsIgnoreCase("views/login.html")) {
			log.debug("We are in the condition.");
			if(user != null) {
				log.debug("we actually made it into the block to redirect.");
				resp.setStatus(300);
				ObjectMapper mapper = new ObjectMapper();
				PrintWriter writer = resp.getWriter();
				String json = mapper.writeValueAsString(user);
				writer.write(json);
				
			} else {
				log.info(resourcePath);
				req.getRequestDispatcher(resourcePath).forward(req, resp);
			}
		} else {
			log.info(resourcePath);
			req.getRequestDispatcher(resourcePath).forward(req, resp);
		}
		
	}


	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		String[] uri = req.getRequestURI().split("/");
		String resource = uri[uri.length-1];
		return 	resource.substring(0, resource.length()-5);
	}
}
