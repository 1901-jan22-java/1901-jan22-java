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

import com.revature.service.DummyUserService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	
	DummyUserService service = new DummyUserService();
	private static Logger log =  Logger.getLogger(HomeServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Attempt to retrieve session, then get user from session
		
		HttpSession session = req.getSession();
		log.trace("IN HOMESERVLET. RETRIEVED SESSION " + session.getId());
		
		//get user from session 
		User user = (User) session.getAttribute("sessionUser");
		
		if(user == null) {
			//no user stored in session. 
			//should not be able to access the home page
			resp.sendRedirect("login");
			log.warn("no user logged in");
		}
		else{
			//welcome page for user 
			log.trace("user logged in session. " + session.getAttributeNames());
			String html = "<div class=\"jumbotron\">\r\n" + 
			"	<h1>Welcome, "+ user.getUsername() +"</h1>\r\n" + 
			"	<i>"+user.getData() +"</i>\r\n";
			List<User> users = service.getAllUser();
			html += " <h4>User Info List</h4><br> "
					+ "<table>" + 
					"        <thead>" + 
					"            <tr>" + 
					"                <th>Username</th>" + 
					"                <th>Password</th>" + 
					"                <th>Bio</th>" + 
					"            </tr>" + 
					"        </thead>" + 
					"        <tbody>";
			for(User u : users) {
				html+=
					"            <tr>" + 
					"                <td>" + u.getUsername() + "</td>" + 
					"                <td>"+ u.getPassword() + "</td>" + 
					"                <td>" + u.getData() + "</td>" + 
					"            </tr>"; }
				html +=	"  </tbody>\r\n" + 
					"    </table>";

		
			
			
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.write(html);
		}
		
	}
}
