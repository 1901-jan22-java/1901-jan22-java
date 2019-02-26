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
public class UserServlet extends HttpServlet {
	
	static final Logger logger = Logger.getLogger(UserServlet.class);
	
	UserService service = new UserService();
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// send request to /users(/pathInfo)
		String pathInfo = req.getPathInfo();
		logger.info("GET: /USERS" + (pathInfo==null?"":pathInfo));
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		
		if(pathInfo == null || pathInfo.trim().equals("/")) {
			//Get All Users
			logger.info("getting all users");
			List<User> users = service.getAllUsers();
			String json = new ObjectMapper()
					.writeValueAsString(users);
		
			writer.write(json);
		}
		else {
			String info = pathInfo.trim().substring(1);
			try {
				int id = Integer.parseInt(info);
				logger.info("getting user by id");
				String json = new ObjectMapper().writeValueAsString(service.getById(id));
				writer.write(json);
			}
			catch(NumberFormatException nfe) {
				logger.info(nfe.getStackTrace());
				logger.info("getting user by username");
				String json = new ObjectMapper().writeValueAsString(service.getByUsername(info));
				writer.write(json);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
