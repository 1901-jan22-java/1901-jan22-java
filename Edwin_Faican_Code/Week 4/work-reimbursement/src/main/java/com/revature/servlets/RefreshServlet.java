package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.users.User;

@WebServlet("/index")
public class RefreshServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(RefreshServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user != null) {
			resp.sendRedirect("home");
		} else {
			req.getRequestDispatcher("login.view").forward(req, resp);
		}
	}
}
