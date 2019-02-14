package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	UserService us = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = us.getAllUsers();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		String data = req.getParameter("bio");
//		User u = new User(username, password, data);
//		us.AddUser(u);
//		doGet(req, resp);
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		if (us.getByUsername(u.getUsername()) == null) {
			us.AddUser(u);
			resp.setStatus(201);
			doGet(req, resp);
		}
		else
		{
			resp.setStatus(409);
		}
		
		

	}
}

class UserService {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("bob", "as", "This is bob's data"));
		users.add(new User("steve", "as", "This is steve's data"));
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User getByUsername(String username) {
		return users.stream()
				.filter(user -> user.getUsername().equalsIgnoreCase(username)).findAny().orElse(null);
	}
	
	public void AddUser(User u) {
		users.add(u);
	}
}
