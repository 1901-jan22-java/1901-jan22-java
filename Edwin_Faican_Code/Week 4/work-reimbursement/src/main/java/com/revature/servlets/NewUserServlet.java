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
import com.javamail.utils.EmailTemp;
import com.jdbc.dao.UserRepository;
import com.revature.users.User;

@WebServlet("/newUser")
public class NewUserServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(NewUserServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserRepository uRepo = new UserRepository();
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		
		PrintWriter writer = resp.getWriter();
		if(uRepo.findUserByUsername(u.getUsername()).getFirstname() != null) {
			resp.setStatus(409);
			
			resp.setContentType("text/html");
			writer.write("Username is already taken.");
		} else if(uRepo.findUserByEmail(u.getEmail()).getFirstname() == null){
			log.info("This is the passed in user: " + u.getFirstname() + u.getLastname() + u.getEmail() + u.getUsername());
			String role = uRepo.findEmail(u.getEmail());
			if(role != null) {
				u.setRole(role);
				u.setaPassword(EmailTemp.sendMail(u));
				User user = uRepo.newUser(u.getFirstname(), u.getLastname(), u.getUsername(), u.getaPassword(), u.getEmail(), u.getRole());
				session.setAttribute("user", user);
				resp.setStatus(201);
				String json = mapper.writeValueAsString(user);

				resp.setContentType("application/json");
				writer.write(json);
			} else {
				resp.setStatus(403);
				resp.setContentType("text/html");
				writer.write("Email is not an authorized. Talk to your manager for support.");
			}
			
			
		} else {
			resp.setStatus(418);

			resp.setContentType("text/html");
			writer.write("Email is already used in an account");
		}
	}
}
