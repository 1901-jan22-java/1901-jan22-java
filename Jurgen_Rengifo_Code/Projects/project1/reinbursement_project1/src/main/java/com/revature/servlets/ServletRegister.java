package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dpr.DprUser;
import com.revature.services.UserService;

@WebServlet("/register")
public class ServletRegister extends HttpServlet {

	private static final long serialVersionUID = -2331941810454783373L;
	private static final Logger log = Logger.getLogger(ServletRegister.class);
	private static final ObjectMapper om = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DprUser u = om.readValue(req.getInputStream(), DprUser.class);
		log.info(u);
		log.info("User: " + UserService.register(u));
	}

}
