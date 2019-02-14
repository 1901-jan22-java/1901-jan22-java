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

import com.fasterxml.jackson.core.JsonParser;
import com.revature.pojos.User;

@WebServlet("/AjaxUsers")
public class AjaxUserServlet extends HttpServlet {

	AjaxUserService us = new AjaxUserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println();
		JsonParser obj;
		String username = "";
		String password = "";
		String response = "Invalid Login";
		System.out.println(username);
		System.out.println(password);
		for (User u : us.getAllUsers())
		{
			if (username.equals(u.getUsername()))
			{
				if (password.equals(u.getPassword())) 
				{
					response = u.getData();
				}
				else
				{
					response = "Invalid Password";
				}
				break;
			}
		}
		System.out.println(response);
		PrintWriter writer = resp.getWriter();
		writer.write(response);
	}
}

class AjaxUserService {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("bob", "as", "This is bob's data"));
		users.add(new User("steve", "as", "This is steve's data"));
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public void AddUser(User u) {
		users.add(u);
	}
}
