package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbc.dao.UserRepository;
import com.revature.users.User;

@WebServlet("/newUser")
public class NewUserServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(NewUserServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserRepository uRepo = new UserRepository();
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		
		if(uRepo.findUserByUsername(u.getUsername()).getFirstname() != null) {
			resp.setStatus(409);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.write("Username is already taken.");
		} else if(uRepo.findUserByEmail(u.getEmail()).getFirstname() == null){
			log.info("This is the passed in user: " + u.getFirstname() + u.getLastname() + u.getPass() + u.getEmail() + u.getUsername() + u.getRole());
			u.setaPassword(u.getPass());
			User user = uRepo.newUser(u.getFirstname(), u.getLastname(), u.getUsername(), u.getaPassword(), u.getEmail(), u.getRole());
			resp.setStatus(201);
			String json = mapper.writeValueAsString(user);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(json);
		} else {
			resp.setStatus(418);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.write("Email is already used in an account");
		}
	}
}
