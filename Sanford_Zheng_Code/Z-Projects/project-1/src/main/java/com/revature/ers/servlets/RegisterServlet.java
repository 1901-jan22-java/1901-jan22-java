package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.services.UserService;
import com.revature.ers.services.dto.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2331941810454783373L;
	private static final Logger log = Logger.getLogger(RegisterServlet.class);
	private static final ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = om.readValue(req.getInputStream(), User.class);
		
		log.info("User applying: " + u);
		
		User processedUser = UserService.register(u);
		
		log.info("User: " + processedUser);
		
		if(processedUser == null) {
			resp.sendError(418, "User already exists.");
		}
		
	}
	
}
