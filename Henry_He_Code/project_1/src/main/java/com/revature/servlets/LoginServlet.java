package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends ProjectServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		{
		    try {
		        Class.forName ("oracle.jdbc.OracleDriver");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }
		}
		Boolean loginVerified = ProjectServlet.dao.verifyCredentials(un, pw);
		if(loginVerified) {
			resp.getWriter().println("Login Credentials Valid: Success!");
		} else {
//			resp.getWriter().println("Login Credentials Invalid: FAIL");
			resp.setContentType("text/html");
		    PrintWriter out = resp.getWriter();

		    out.println("Something went wrong");
		}
	}
	
}
