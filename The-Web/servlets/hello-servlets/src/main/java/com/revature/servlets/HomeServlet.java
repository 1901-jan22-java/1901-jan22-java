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

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(HomeServlet.class);
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		log.trace("IN HOMESERVLET. RETRIEVED SESSION" + session.getId());
		User user = (User) session.getAttribute("sessionUser");
		if(user ==null) {
			resp.sendRedirect("login");
			log.warn("no user logged in");
		}
		else {
			log.trace("user logged in session no. " + session.getAttributeNames());
			String html = "<h1>Welcome, " + user.getUsername() + "!</h1>";
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.write(html);
		}
	}
}
