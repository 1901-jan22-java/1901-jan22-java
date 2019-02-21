package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/home")
public class HomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Attempt to retrieve session, then get user from session
		
		HttpSession session = req.getSession(false);
		
		if(session == null) {
			resp.setStatus(500);
			resp.sendRedirect("login.view");
		}
		else{
			resp.sendRedirect("home.view");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
}
