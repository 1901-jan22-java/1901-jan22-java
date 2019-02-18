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
import com.revature.users.User;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(HomeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//Get user from session
		User user = (User) session.getAttribute("user");

		if(user.getUsername() == null) {
			//no user stored in seesion.
			//Should not be able to access the home page.
			//redirect to login. 
			resp.sendRedirect("index.html");
		} else if(user.getRole().equalsIgnoreCase("Employee")) {
			resp.setStatus(200);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			//Welcome page for user
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(json); 
		} else {
			resp.setStatus(202);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(json); 
		}
	}
}
