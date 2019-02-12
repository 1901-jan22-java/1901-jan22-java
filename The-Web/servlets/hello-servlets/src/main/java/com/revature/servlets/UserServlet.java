package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	
	
	/*
	 * Use Jackson ObjectMapper to send response of all users 
	 * as a JSON string 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	
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
}



