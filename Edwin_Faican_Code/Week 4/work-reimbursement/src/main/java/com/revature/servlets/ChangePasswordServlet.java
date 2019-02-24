package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.users.User;

@WebServlet("/verifyPass")
public class ChangePasswordServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(ChangePasswordServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter writer = resp.getWriter();
		
		User u = mapper.readValue(req.getInputStream(), User.class);
		u.setaPassword(u.getPass());
		log.debug(u.getaPassword() + " .... " + user.getaPassword());
		if(u.getaPassword() == user.getaPassword()) {
			resp.setStatus(200);
			resp.setContentType("text/html");
			writer.write("Passwords match!");
		} else {
			resp.setStatus(400);
			resp.setContentType("text/html");
			writer.write("Passwords do not match!");
		}
		
	}
}
