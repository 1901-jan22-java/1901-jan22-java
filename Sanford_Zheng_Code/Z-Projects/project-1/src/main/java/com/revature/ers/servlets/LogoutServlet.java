package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dao.dto.User;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1560355907437843017L;
	private static final Logger log = Logger.getLogger(LogoutServlet.class);
	private static final ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session == null) {
			log.info("Could not find session for logout.");
			return;
		}
		log.info("Logging out: " + (User)session.getAttribute("user"));
		User uback = om.readValue(req.getInputStream(), User.class);
		log.info("Returned user: " + uback);
	}
	
}
