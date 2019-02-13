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
import com.revature.services.UserService;
import com.revature.services.pojos.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	UserService service = new UserService();
	private static Logger log = Logger.getLogger(LoginServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		User u = mapper.readValue(req.getInputStream(), User.class);

		User storedUser = service.getByUsername(u.getUsername());

		if (storedUser == null) {
			resp.setStatus(418);
		} else if (!storedUser.getPassword().equals(u.getPassword())) {
			resp.setStatus(409);
		} else {
			resp.setStatus(200);
			
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			
			log.info("CREATED SESSION " + session.getId());
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(mapper.writeValueAsString(userStored));
		}
	}

}