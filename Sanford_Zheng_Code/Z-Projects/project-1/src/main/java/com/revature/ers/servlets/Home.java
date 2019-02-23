package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home. I don't know what I'm doing...
 */
@WebServlet("/home")
public class Home extends HttpServlet {

	private static final long serialVersionUID = 8550366702754639405L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			req.getRequestDispatcher("html/home.html").forward(req, resp);
		} else {
			resp.getWriter().write("Invalid session. Please login first!");
			req.getRequestDispatcher("html/login.html").forward(req, resp);
		}
	}

}
