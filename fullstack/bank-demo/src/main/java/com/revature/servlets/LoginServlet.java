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
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	final static Logger logger = Logger.getLogger(LoginServlet.class);
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		User info = mapper
				.readValue(req.getInputStream(),User.class);		
		logger.info("Logging in user with credentials " + info);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		
		User u = service.login(info.getUsername(), info.getPassword());
		if(u == null) {
			//invalid credentials
			writer.write(mapper.writeValueAsString(null));
		}
		else {
			//valid login credentials 
			HttpSession session = req.getSession();
			logger.info("Adding user to session " + session.getId());
			session.setAttribute("user", u);
			String json = mapper.writeValueAsString(u);
			writer.write(json);
			
		}
	
	}
}
