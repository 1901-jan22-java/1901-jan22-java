package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.user.User;
import com.revature.user.UserRepo;

@WebServlet("/registerUser")
public class registerUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	//method to add a user
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		UserRepo user = new UserRepo(); //userrepo lets us check the database for existing user
		ObjectMapper mapper = new ObjectMapper();
		User tmp = mapper.readValue(req.getInputStream(), User.class); //creates a temperary user
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		if(user.findUserByUsername(tmp.getUsername()) != null)
		{
			resp.setStatus(409);
			writer.write("<p><b><i>Username is taken</i></b></p>");
		}
		else if (user.findUserByEmail(tmp.getEmail()) != null)
		{
			resp.setStatus(409);
			writer.write("<p><b><i>Email is already linked to another account</i></b></p>");
		}
		else
		{
			user.addUser(	tmp.getUsername(), tmp.getPassword(), tmp.getFirstName(), 
							tmp.getLastName(), tmp.getEmail(), tmp.getRoleId());
			resp.setStatus(201);
			writer.write("<p><b><i>Success!</i></b></p>");
		}
	}
}
