package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(UserServlet.class);
	UserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter writer = resp.getWriter();
		//Represents everything after the designated slash before the asterisk
		String pathInfo = req.getPathInfo();
		if(pathInfo == null || pathInfo.trim().equals("/")) {
			List<User> users = service.getAllUsers();
			String json = mapper.writeValueAsString(users);
			resp.setContentType("application/json");
			writer.write(json);
		} else {
			try {
				int index = Integer.parseInt(pathInfo.substring(1));
				User user = service.findById(index);
				String json = mapper.writeValueAsString(user);
				resp.setContentType("application/json");
				writer.write(json);
			} catch(NumberFormatException e) {
				String username = pathInfo.substring(1);
				User user = service.findByUN(username);
				String json = mapper.writeValueAsString(user);
				resp.setContentType("application/json");
				writer.write(json);
			}	
		}	
	}
}
