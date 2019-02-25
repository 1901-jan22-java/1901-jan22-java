package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dpr.DprUser;
import com.revature.services.UserService;

@WebServlet("/user")
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = -5371584794586949997L;
	private static final ObjectMapper om = new ObjectMapper();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			resp.sendError(418, "Session not found.");
			return;
		}
		Object obj = session.getAttribute("user");
		if (obj == null || !(obj instanceof DprUser)) {
			resp.sendError(404, "User not found within Session.");
			return;
		}
		DprUser u = (DprUser) obj;
		String json = new ObjectMapper().writeValueAsString(u);

		resp.setContentType("application/json");
		resp.getWriter().println(json);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		Object obj = session.getAttribute("user");

		DprUser u = om.readValue(req.getInputStream(), DprUser.class);
		if (obj == null || !(obj instanceof DprUser) || UserService.login(u) == null) {
			resp.getWriter().write("Invalid user. Please try logging in again.");
			req.getRequestDispatcher("html/login.html").forward(req, resp);
		}
		String json = new ObjectMapper().writeValueAsString(UserService.getAllUsers());
		resp.setContentType("application/json");
		resp.getWriter().println(json);
	}
}
