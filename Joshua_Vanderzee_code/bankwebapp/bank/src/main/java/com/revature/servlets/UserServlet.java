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
import com.revature.services.UserService;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
	Logger log = Logger.getLogger(TestServlet.class);
	UserService us = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		String pathInfo = req.getPathInfo();
		if (pathInfo == null || pathInfo.trim().equals(""))
		{
			String json = mapper.writeValueAsString(us.getAllUsers());
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.println(json);
		} 
		else
		{
			String info = pathInfo.trim().substring(1);
			try {
				int id = Integer.parseInt(info);
				String json = mapper.writeValueAsString(us.getUserByUserId(id));
				PrintWriter writer = resp.getWriter();
				resp.setContentType("application/json");
				writer.println(json);
			} catch (NumberFormatException nfe) {
				log.info(nfe.getStackTrace());
				log.info("getting username");
				String json = mapper.writeValueAsString(us.getUserByUsername(info)); //users.stream().filter(u -> u.getUsername().equals(info)).findAny().get()
				PrintWriter writer = resp.getWriter();
				resp.setContentType("application/json");
				writer.println(json);
			} catch (IndexOutOfBoundsException ioobe) {
				log.info(ioobe.getStackTrace());
				String json = mapper.writeValueAsString(us.getAllUsers());
				PrintWriter writer = resp.getWriter();
				resp.setContentType("application/json");
				writer.println(json + "\n\n\n" + ioobe.getStackTrace());
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = new ObjectMapper().readValue(req.getInputStream(), User.class);
		u = us.Add(u);
		if (u == null) {
			resp.setStatus(409);
		}
		else
		{
			log.info("Successfully made " + u);
			resp.setStatus(201);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.println(new ObjectMapper().writeValueAsString(u));			
		}

	}
}
