package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;

@WebServlet("/userroles")
public class ServletUserRole extends HttpServlet {

	private static final long serialVersionUID = -4594490684703098420L;
	private static final Logger log = Logger.getLogger(ServletUserRole.class);
	private static final ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> roles = UserService.getAllRoles();
		String json = om.writeValueAsString(roles);
		log.info(json);
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}
}