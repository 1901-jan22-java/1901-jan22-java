package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
	
	UserService uService = new UserService();
	final static Logger log = Logger.getLogger(UserServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// send request to /users(/pathInfo)
		String pathInfo = req.getPathInfo();
		log.info("GET: /USERS" + (pathInfo==null ? "" : pathInfo));
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		if(pathInfo == null || pathInfo.trim().contentEquals("/")) {
			//Get all users
			List<User> users = uService.getAllUsers();
			String json = new ObjectMapper().writeValueAsString(users);
			pw.write(json);
		}
		else {
			String info = pathInfo.trim().substring(1);
			try {
				int id = Integer.parseInt(info);
				log.info("getting user by id");
				pw.write(new ObjectMapper().writeValueAsString(
						uService.getById(id)));
			}catch(NumberFormatException nfe) {
				log.info(nfe.getStackTrace());
				log.info("getting user by username");
				pw.write(new ObjectMapper().writeValueAsString(
						uService.getByUsername(info)));
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Below, we get the input stream of the request body
		 * and use Jackson's object mapper to create an
		 * instance of a user object with the data
		 * 
		 */
		
		User u = new ObjectMapper().readValue(req.getInputStream(), User.class);
		u = uService.add(u);
		if(u==null) {
			//something went wrong
			resp.setStatus(409);
		}
		log.info("Successfully added user" + u);
		resp.setStatus(201);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(new ObjectMapper().writeValueAsString(u));
		
	}

}