package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.services.UserService;
import com.revature.ers.services.dto.User;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5371584794586949997L;
	private static final ObjectMapper om = new ObjectMapper();

	/**
	 * Get User info for user.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			resp.sendError(418, "Session not found.");
			return;
		}
		Object obj = session.getAttribute("user");
		if (obj == null || !(obj instanceof User)) {
			resp.sendError(404, "User not found within Session.");
			return;
		}
		User u = (User) obj;
		String json = new ObjectMapper().writeValueAsString(u);

		resp.setContentType("application/json");
		resp.getWriter().println(json);
	}

	/**
	 * Get all Users for Admin
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		Object obj = session.getAttribute("user");

		User u = om.readValue(req.getInputStream(), User.class);
		if (obj == null || !(obj instanceof User) || UserService.login(u) == null) {
			resp.getWriter().write("Invalid user. Please try logging in again.");
			req.getRequestDispatcher("html/login.html").forward(req, resp);
		}

		String json = new ObjectMapper().writeValueAsString(UserService.getAllUsers());

		resp.setContentType("application/json");
		resp.getWriter().println(json);
	}

}
