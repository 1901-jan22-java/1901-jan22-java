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

import com.revature.reimbursement.ReimbursementRepo;
import com.revature.user.User;

@WebServlet("/homeManager")
public class HomeManagerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Logger log =  Logger.getLogger(HomeManagerServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Attempt to retrieve session, then get user from session
		
		HttpSession session = req.getSession();
		log.trace("IN HOMEManagerSERVLET. RETRIEVED SESSION " + session.getId());
		
		//get user from session 
		User user = (User) session.getAttribute("sessionUser");
		ReimbursementRepo repo = new ReimbursementRepo();
		
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
			"	<h1>Welcome, "+ user.getUsername() +"</h1>\r\n"+
			"	<div>These are your reimbursements\n"+ repo.getReimbursements(user) +"</div>"
					+ "</div>";
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.write(html);
		}
		
	}
}