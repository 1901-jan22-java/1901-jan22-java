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
import com.revature.user.User;
import com.revature.user.UserRepo;

@WebServlet("/logIn")
public class logIn extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(logIn.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		UserRepo userRep = new UserRepo();
		User u = mapper.readValue(req.getInputStream(), User.class);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		u = userRep.logIn(u.getUsername(), u.getPassword());
		if(u.getUsername() == null || u == null){
			resp.setStatus(409);
			writer.write("<p><b><i>Log In Credentials Invalid</i></b></p>");
		}
		else{
			resp.setStatus(200);
			log.trace("user logged in as " + u.toString());
			//manage session
			HttpSession session = req.getSession();
			session.setAttribute("sessionUser", u);
			log.info("CREATED SESSION " + session.getId());

			resp.sendRedirect("home");
		}
	}


}
