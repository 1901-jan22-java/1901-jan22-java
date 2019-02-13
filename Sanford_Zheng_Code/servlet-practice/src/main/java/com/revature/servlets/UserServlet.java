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
import com.revature.servlets.pojos.User;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4955043028429511943L;
	UserService service = new UserService();
	
	/*
	 * Jackson ObjectMapper to send respose of all users
	 * as a JSON string.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> users = service.getAllUsers();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		//just to see...
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		pw.write(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String data = req.getParameter("data");
		
		User u = new User(username, password, data);
		
		service.addUser(u);
		
		doGet(req, resp);
	}
	
}

class UserService {
	static List<User> users = new ArrayList<>();

	static {
		users.add(new User("gb1", "123", "this is a user"));
		users.add(new User("gb2", "123", "this is a user"));
		users.add(new User("gb3", "123", "this is a user"));
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
}
