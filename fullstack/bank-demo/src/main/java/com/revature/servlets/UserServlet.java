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
	
	UserService uService = new UserService();
	final static Logger logger = 
			Logger.getLogger(UserServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// send request to /users(/pathInfo)
		String pathInfo = req.getPathInfo();
		logger.info("GET: /USERS" + (pathInfo==null?"":pathInfo));
		
		if(pathInfo == null || pathInfo.trim().equals("/")) {
			//Get All Users
			logger.info("getting all users");
			List<User> users = uService.getAllUsers();
			String json = new ObjectMapper()
					.writeValueAsString(users);
			PrintWriter writer = resp.getWriter();
			
			resp.setContentType("application/json");
			writer.write(json);
		}
		else {
			String info = pathInfo.trim().substring(1);
			try {
				int id = Integer.parseInt(info);
				logger.info("getting user by id");
			}
			catch(NumberFormatException nfe) {
				logger.info(nfe.getStackTrace());
				logger.info("getting user by username");
			}
		}
		
		
	
	}
	

}
