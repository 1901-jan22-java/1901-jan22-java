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

import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	UserService uService = new UserService();
	Logger log = Logger.getLogger(HomeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		log.trace("IN HOMESERVLET. RETRIEVED SESSION" + session.getId());
		User user = (User) session.getAttribute("sessionUser");
		
		if (user == null) {
			resp.sendRedirect("login");
			log.warn("No user logged in");
		}
		else {
			log.trace("User logged in session" + session.getAttribute("sessionUser"));
			String html = "<div class=\"jumbotron\">\r\n"
					+ "<h1> Welcome" + user.getFn() + "</h1>\n"
							+ "</div>";
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.write(html);
		}
		
	}

}
