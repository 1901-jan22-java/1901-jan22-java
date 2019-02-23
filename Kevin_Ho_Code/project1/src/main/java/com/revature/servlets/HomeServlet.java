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
import com.revature.user.User;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Logger log =  Logger.getLogger(HomeServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Attempt to retrieve session, then get user from session
		
		HttpSession session = req.getSession();
		log.trace("IN HOMESERVLET. RETRIEVED SESSION " + session.getId());
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		
		//get user from session 
		User user = (User) session.getAttribute("sessionUser");
		String json = mapper.writeValueAsString(user);

		if(user == null || user.getUsername() == null) {
			//no user stored in session. 
			//should not be able to access the home page
			resp.sendRedirect("login");
			log.warn("no user logged in");
		} 
		else if(user.getRoleId() == 1)
		{
			resp.setStatus(201);
			writer.write(json);
			log.debug("manager view");
		}
		else
		{
			resp.setStatus(200);
			writer.write(json);
			log.debug("user view");
		}
	}
}