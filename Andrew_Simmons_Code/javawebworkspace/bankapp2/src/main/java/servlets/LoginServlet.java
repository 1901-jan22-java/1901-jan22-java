package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.User;

import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	UserService uService = new UserService();
	final static Logger logger = 
			Logger.getLogger(LoginServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("index.html");
	
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		User storedUser = uService.getByUsername(u.getUsername());
		if(storedUser == null) {
			//no user by this username exists
			resp.setStatus(418);
			
		}
		else if(storedUser.getPassword().equals(u.getPassword())) {
			//user is logged in
			resp.setStatus(200);
		
			//manage session
			HttpSession session = req.getSession();
			session.setAttribute("sessionUser", storedUser);


			resp.sendRedirect("home");
		}
		else {
			//incorrect password or some other issue. 
			resp.setStatus(418);
		
			//forward to the error page 
		}
	}

}
