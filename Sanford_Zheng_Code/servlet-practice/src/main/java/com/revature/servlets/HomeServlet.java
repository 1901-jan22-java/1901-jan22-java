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

import com.revature.services.pojos.User;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6862776717020478315L;
	private static Logger log = Logger.getLogger(HomeServlet.class);
	//	stuff happens here
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Attempt to retrieve session, then get user from session
		HttpSession session = req.getSession();
		
		log.trace("IN HOMESERVLET, RETREIVE SESSION " + session.getId());
		
		User u = (User) session.getAttribute("user");
		
		if(u == null) {
			resp.sendRedirect("index.html");
			log.warn("No user logged in...");
		} else {
//			resp.sendRedirect("home.html");
			
			String html = "<h1>Welcome, " + u.getUsername() + "!</h1>";
			PrintWriter pw = resp.getWriter();
			resp.setContentType("text/html");
			pw.write(html);
		}
	}
	
}
