package com.ers.serlvets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbc.pojos.Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	UserService service = new UserService();
	static final Logger log = Logger.getLogger(LoginServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Inside do post method in login servlet");
		ObjectMapper mapper = new ObjectMapper();
		
		Users u = mapper.readValue(req.getInputStream(), Users.class);
		
		Users storedUser = service.getByUsername(u.getUsername());
		log.info(storedUser);
		log.info(u);
		if(storedUser == null) {
			log.info("user is null");
			resp.setStatus(401);
			
		} else if(storedUser.getPassword().equals(u.getPassword()) ) {
			resp.setStatus(200);
			log.info("logged in as user" + storedUser.toString());
			HttpSession session = req.getSession();
			session.setAttribute("user", storedUser);
			log.info("CREATED SESSION " + session.getId());
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(mapper.writeValueAsString(storedUser));
		} else {
			log.info("user isnt null, but password didnt pass");
			resp.setStatus(401);
		}
	}
}
