package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	UserService service = new UserService();
	private static Logger log = Logger.getLogger(HomeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		log.info("This is the session id in home servlet: " + session.getId());
		List<User> users = service.getAllUsers();
		//Get user from session
		User user = (User) session.getAttribute("user");
		
		if(user == null) {
			//no user stored in seesion.
			//Should not be able to access the home page.
			//redirect to login. 
			resp.sendRedirect("login");
		} else {
			//Welcome page for user
			String html = "<h1>Welcome, " + user.getUsername() + "!</h1><i>" + user.getData() + "</i>";
			
			html += "<table><thead><tr><th>Username</th><th>Password</th><th>Bio</th></tr></thead><tbody>";
			
			for(User u : users) {
				html+= "<tr><td>" + u.getUsername() + "</td><td>" + u.getPassword() + "</td><td>" + u.getData() + "</td></tr>";
			}
			
			html += "</tbody></table>";
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.write(html);
		}
	}
}
