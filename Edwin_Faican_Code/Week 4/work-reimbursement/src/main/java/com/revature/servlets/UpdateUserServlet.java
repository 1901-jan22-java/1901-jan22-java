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
import com.jdbc.dao.UserRepository;
import com.revature.users.User;

@WebServlet("/changeUser")
public class UpdateUserServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(UpdateUserServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter writer = resp.getWriter();
		
		User u = mapper.readValue(req.getInputStream(), User.class);
		
		if(u.getUsername() == null) {
			//Changing the password
			if(u.getPass().length() < 8) {
				resp.setStatus(400);
				resp.setContentType("text/html");
				writer.write("Password must be 8 or more characters");
			} else {
				user.setaPassword(u.getPass());
				user = (new UserRepository()).updateUser(user);
				String json = mapper.writeValueAsString(user);
				
				session.setAttribute("user", user);
				
				resp.setContentType("application/json");
				writer.write(json);
			}
			
		} else {
			//Changing the User name
			User storedU = (new UserRepository()).findUserByUsername(u.getUsername());
			if(storedU.getFirstname() == null) {
				//Success
				user.setUsername(u.getUsername());
				user = (new UserRepository()).updateUser(user);
				String json = mapper.writeValueAsString(u);

				session.setAttribute("user", user);
				
				resp.setContentType("application/json");
				writer.write(json);
			} else {
				resp.setStatus(403);
				resp.setContentType("text/html");
				writer.write("Username is already in use.");
			}
		}
	}
}
