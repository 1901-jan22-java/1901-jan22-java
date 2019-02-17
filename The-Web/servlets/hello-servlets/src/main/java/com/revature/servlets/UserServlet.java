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
import com.revature.service.DummyUserService;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
<<<<<<< HEAD

	DummyUserService service = new DummyUserService();
=======
	
	DummyUserService service = new DummyUserService();
	
>>>>>>> master
	
	/*
	 * Use Jackson ObjectMapper to send response of all users 
	 * as a JSON string 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<User> users = service.getAllUser();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}
	
	/*
	 * working with FORM data! Not going to use often at all
	 */
<<<<<<< HEAD
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		String data = req.getParameter("bio");
//		User u = new User(username, password, data);
//		
//		service.addUser(u);
//		doGet(req, resp);
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
		HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		if(service.getByUsername(u.getUsername())==null){
			//no conflict, can create user
			service.addUser(u);
			resp.setStatus(201);
			doGet(req, resp);
		}
		else{
			//username is already used. set http response status to conflict
			resp.setStatus(409);
		}

	}
=======
	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String data = req.getParameter("bio");
		User u = new User(username, password, data);
		service.addUser(u);
		doGet(req, resp);
	} */
>>>>>>> master

	//Responds to POST requests with request body
	@Override
	protected void doPost(HttpServletRequest req, 
		HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		if(service.getByUsername(u.getUsername())==null){
			//no conflict, can create user
			service.addUser(u);
			resp.setStatus(201);
			doGet(req, resp);
		}
		else{
			//username is already used. set http response status to conflict
			resp.setStatus(409);
		}

		
		
	}
}



<<<<<<< HEAD
=======


>>>>>>> master

