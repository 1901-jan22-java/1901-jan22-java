package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dto.User;

/**
 * Servlet implementation class Home. I don't know what I'm doing...
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 8550366702754639405L;
//	private static final ObjectMapper om = new ObjectMapper();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			resp.getWriter().write("Invalid session. Please login first!");
			req.getRequestDispatcher("html/login.html").forward(req, resp);
			return;
		}
		Object obj = session.getAttribute("user");
		if(obj== null || !(obj instanceof User)) {
			resp.getWriter().write("Invalid session. Please login first!");
			req.getRequestDispatcher("html/login.html").forward(req, resp);
			return;
		}
//		User u = (User) obj;
		
		req.getRequestDispatcher("html/home.html").forward(req, resp);
	}

}
