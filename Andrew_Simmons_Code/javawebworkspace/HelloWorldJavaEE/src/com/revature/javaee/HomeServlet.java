package com.revature.javaee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	
	private static Logger log =  Logger.getLogger(HomeServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Attempt to retrieve session, then get user from session
		
		HttpSession session = req.getSession();
		log.trace("IN HOMESERVLET. RETRIEVED SESSION " + session.getId());
		
		//get user from session 
		User user = (User) session.getAttribute("sessionUser");
		
		if(user == null) {
			//no user stored in session. 
			//should not be able to access the home page
			resp.sendRedirect("login");
			log.warn("no user logged in");
		}
		
	}
}