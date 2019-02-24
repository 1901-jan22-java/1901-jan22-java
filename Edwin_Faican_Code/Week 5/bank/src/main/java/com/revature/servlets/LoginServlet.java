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
	
	public static Logger log = Logger.getLogger(LoginServlet.class);
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter writer = resp.getWriter();
		
		User user = (User) mapper.readValue(req.getInputStream(), User.class);
		User u = service.login(user.getUsername(), user.getPassword());
		if(u != null) {
			String json = mapper.writeValueAsString(u);
			resp.setContentType("application/json");
			writer.write(json);
		} else {
			resp.setStatus(404);
			resp.setContentType("text/html");
			writer.write("Username/Password not correct.");
		}
	}
}
