package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jdbc.util.ConnectionFactory;

public class LoginServlet extends ProjectServlet {
	
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LoginServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] credentials = req.getReader().readLine().split(",");
		String un = credentials[0];
		String pw = credentials[1];
		logger.info("Username: " + credentials[0] +" | "+ "Password: " + credentials[1]);
		String uid_info = ProjectServlet.dao.verifyCredentials(un, pw);
		if(uid_info == null) {
			resp.setStatus(401);
		} else {
			resp.setStatus(200);
//			for some ungodly reason, setting the attributing isn't doing anything
//			I'll fix it later...
//			req.setAttribute("uid_info", uid_info);
			UserServlet.set_uid_info(uid_info);
			logger.info("uid_info: " + uid_info);
			req.getRequestDispatcher("/user").forward(req,resp);
//			resp.sendRedirect("userpage.html");
		}
	}
	
}
