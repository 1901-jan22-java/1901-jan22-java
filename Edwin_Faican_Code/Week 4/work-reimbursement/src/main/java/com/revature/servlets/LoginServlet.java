package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbc.dao.UserRepository;
import com.revature.users.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("This is happening!)");
		UserRepository uRepo = new UserRepository();
		ObjectMapper  mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		User storedUser = uRepo.findUserByUsername(u.getUsername());
		
		if(storedUser == null) {
			resp.setStatus(418);
		} else if(User.checkPass(u.getPass(),storedUser.getaPassword())){
			log.debug("We found the user.");
			resp.setStatus(200);
//			resp.setContentType("application/json");
//			PrintWriter writer = resp.getWriter();
//			writer.write(mapper.writeValueAsString(storedUser));
			HttpSession session = req.getSession();
			session.setAttribute("user", storedUser);
			resp.sendRedirect("home");
		} else {
			resp.setStatus(404);
		}
	}
}
