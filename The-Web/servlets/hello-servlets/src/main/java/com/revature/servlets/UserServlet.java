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

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	
	UserService service = new UserService();
	/*
	 * Use Jackson ObjectMapper to send response of all users 
	 * as a JSON string 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<User> users = service.getAllUser();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}
	/*
	 * working with FORM data!
	 */
/*	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String data = req.getParameter("bio");
		User u = new User(username, password, data);
		service.addUser(u);
		doGet(req, resp);
	}
*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		if(service.getByUsername(u.getUsername())==null){
			//no conflict. can create user
			service.addUser(u);
			resp.setStatus(201);
			doGet(req, resp);
			
		}
		else{
			//username is already used. set http response status to conflict
			resp.setStatus(409);
		}
	}
}




class UserService{
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("gb", "123", "this is a user"));
		users.add(new User("test", "user", "test"));
		users.add(new User("Beyonce", "knowles", "is awesome"));
	}
	
	public List<User> getAllUser(){
		return users;
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
	public User getByUsername(String username){
		//want to get user by username that matches
		//could loop through each user
		/*for(User u : users){
			if(username.equalsIgnoreCase(u.getUsername())){
				return u;
			}
		}
		return null;
		*/
		
		return 	users.stream()
				.filter(user -> user.getUsername().equalsIgnoreCase(username))
				.findAny()
				.orElse(null);
		
	}
}
