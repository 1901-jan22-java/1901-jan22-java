package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;
import com.revature.services.pojos.User;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4955043028429511943L;
	UserService service = new UserService();
	
	/*
	 * Jackson ObjectMapper to send response of all users
	 * as a JSON string.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.getAllUsers();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		//just to see...
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		pw.write(json);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException
//	{
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		String data = req.getParameter("data");
//		
//		User u = new User(username, password, data);
//		
//		service.addUser(u);
//		
//		doGet(req, resp);
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		ObjectMapper mapper = new ObjectMapper();

		User u = mapper.readValue(req.getInputStream(), User.class);
		
		if(service.getByUsername(u.getUsername()) == null) {
			service.addUser(u);
			resp.setStatus(201);
			doGet(req, resp);
		}else {
			resp.setStatus(409);
		}
	}
}
