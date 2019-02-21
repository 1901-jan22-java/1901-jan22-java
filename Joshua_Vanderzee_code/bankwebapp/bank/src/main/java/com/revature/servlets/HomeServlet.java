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

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		log.trace("In home servlet retrieved session " + session.getId());
		User user = (User)session.getAttribute("sessionUser");
		if (user == null)
		{
			resp.sendRedirect("login");
		}
		else
		{
			resp.sendRedirect("home.view");
		}
	}
}
