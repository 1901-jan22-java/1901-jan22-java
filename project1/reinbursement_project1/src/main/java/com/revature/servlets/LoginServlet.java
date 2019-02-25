package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.User;
import com.revature.services.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2530248194425658345L;
	private static final Logger log = Logger.getLogger(LoginServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		User u = om.readValue(req.getInputStream(), User.class);
		
		User uStored = UserService.login(u);
		
		if(uStored == null) {
			log.info("User not found or login credentials are incorrect.");
			resp.sendError(418, "User not found or login credentials are incorrect.");
			req.getRequestDispatcher("html/login.html").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			log.info("Logging in: "+(User)session.getAttribute("user"));

			resp.setContentType("application/json");
			resp.getWriter().write(om.writeValueAsString(uStored));
		}
		
	}
	
}
