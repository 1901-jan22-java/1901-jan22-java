package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dao.dto.User;
import com.revature.ers.services.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2530248194425658345L;
	private static final ObjectMapper om = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = om.readValue(req.getInputStream(), User.class);
		User valid = UserService.getUser(u.getUsername());
		
		if(valid == null) {
			resp.getWriter().write("Username or password is incorrect.");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("username", u.getUsername());
			req.getRequestDispatcher("html/home.html").forward(req, resp);
		}
		
	}
	
}
