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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	DummyUserService dus = new DummyUserService();
	
	private static Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		
		User storedUser = dus.getByUsername(u.getUsername());
		if (storedUser == null) {
			resp.setStatus(418);
		} else if (storedUser.getPassword().equals(u.getPassword())) {
			resp.setStatus(200);
			HttpSession session = req.getSession();
			session.setAttribute("sessionUser", storedUser);
			log.info(session.getId());
//			PrintWriter writer = resp.getWriter();
//			resp.setContentType("application/json");
//			log.trace(mapper.writeValueAsString(u));
//			writer.write(mapper.writeValueAsString(u));
			resp.sendRedirect("home");
		} else {
			resp.setStatus(418);
		}
	}
}
