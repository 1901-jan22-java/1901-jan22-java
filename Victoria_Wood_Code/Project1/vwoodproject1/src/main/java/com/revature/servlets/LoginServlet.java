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
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	static UserService uService = new UserService();
	static Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User info = mapper.readValue(req.getInputStream(), User.class);
		PrintWriter writer = resp.getWriter();
		
		User u = uService.logIn(info.getUsername(), info.getPassword());
		if(u == null) {
			resp.setStatus(418);
			log.trace("User not found");
			resp.setContentType("application/json");
			writer.write(mapper.writeValueAsString(u));
			
		} else {
			resp.setStatus(200);
			HttpSession session = req.getSession();
			session.setAttribute("sessionUser", u);
			resp.setContentType("application/json");
			writer.write(mapper.writeValueAsString(u));
			//resp.sendRedirect("home");
		}
	}
}
