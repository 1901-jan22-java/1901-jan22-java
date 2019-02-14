package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/users")
public class UserServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(UserServlet.class);
	UserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
		List<User> users = service.getAllUsers();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
		
	}
	
	//USING FORM DATA - OBTRUSIVE!
//	@Override 
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		String bio = req.getParameter("bio");
//		
//		User u = new User(username, password, bio);
//		service.addUser(u);
//		
//		doGet(req, resp);
//	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET");
		ObjectMapper  mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		if(service.getByUsername(u.getUsername()) == null) {
			//No conflict; can create user
			service.addUser(u);
			resp.setStatus(201);
			doGet(req,resp);
		} else {
			//Username is already in use. Set Http status to conflict. 
			resp.setStatus(409);
		}
	}
}
