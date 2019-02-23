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
import com.revature.ers.services.UserService;

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
		
		if(UserService.login(u) == null) {
			resp.getWriter().write("Username or password is incorrect.");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			log.info("Object: "+(User)session.getAttribute("user"));
			
			req.getRequestDispatcher("/home").forward(req, resp);
		}
		
	}
	
}
