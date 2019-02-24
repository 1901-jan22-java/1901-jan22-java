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
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/register")
public class NewUserServlet extends HttpServlet{
	
	public static Logger log = Logger.getLogger(NewUserServlet.class);
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user =  mapper.readValue(req.getInputStream(), User.class);
		User u = service.findByUN((user.getUsername()));
		if(u.getFirstname() != null) {
			log.info("We are going in here" + u.toString());
			
			//Send error that user exists. 
		} else {
			user = service.saveUser(user);
			String json = mapper.writeValueAsString(user);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(json);
		}
	}
}
