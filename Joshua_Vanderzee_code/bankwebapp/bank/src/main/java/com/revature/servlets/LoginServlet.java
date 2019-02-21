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
import com.revature.pojos.User;
import com.revature.services.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login.view");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService us = new UserService();
		ObjectMapper mapper = new ObjectMapper();
		log.info(req.getParameterNames());
		User u = mapper.readValue(req.getInputStream(), User.class);
		User user = us.login(u.getUsername(), u.getPassword()) ;
		if (user != null) {
			resp.setStatus(200);
			HttpSession session = req.getSession();
			session.setAttribute("sessionUser", user);
			log.info(session.getId());
			resp.sendRedirect("home.view");
		} else {
			resp.setStatus(406);
		}
	}
	
}
