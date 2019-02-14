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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(LoginServlet.class);
	UserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper  mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		User storedUser = service.getByUsername(u.getUsername());
		log.trace(storedUser);
		if(storedUser == null) {
			resp.setStatus(418);
		} else if(storedUser.getPassword().contentEquals(u.getPassword())){
			resp.setStatus(200);
			log.trace("we are here!");
//			resp.setContentType("application/json");
//			PrintWriter writer = resp.getWriter();
//			writer.write(mapper.writeValueAsString(storedUser));
			HttpSession session = req.getSession();
			session.setAttribute("user", storedUser);
			log.info("This is the session id in login servlet: " + session.getId());
			resp.sendRedirect("home");
		} else {
			resp.setStatus(404);
		}
	}
}
