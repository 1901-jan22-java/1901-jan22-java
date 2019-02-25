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
import com.revature.service.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	DummyUserService service = new DummyUserService();
	static final Logger log = Logger.getLogger(LoginServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		User u = mapper.readValue(req.getInputStream(), User.class);
		
		User storedUser = service.getByUsername(u.getUsername());
		if(storedUser == null) {
			//no user by this username exists
			resp.setStatus(418);
		}
		else if(storedUser.getPassword().equals(u.getPassword())) {
			//user is logged in
			resp.setStatus(200);
			
			//manage session
			HttpSession session = req.getSession();
			session.setAttribute("user", storedUser);
			log.info("CREATED SESSION " + session.getId());
			
			/*// if we want user info immediately, do this
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(mapper.writeValueAsString(u));*/
			resp.sendRedirect("home");
			
			
		}
		else {
			//incorrect password or some other issue. 
			resp.setStatus(418);
		}
	}

	
}
