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

import com.revature.reimbursement.Reimbursement;
import com.revature.reimbursement.ReimbursementRepo;
import com.revature.user.User;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Logger log =  Logger.getLogger(HomeServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Attempt to retrieve session, then get user from session
		
		HttpSession session = req.getSession();
		log.trace("IN HOMESERVLET. RETRIEVED SESSION " + session.getId());
		
		//get user from session 
		User user = (User) session.getAttribute("sessionUser");
		ReimbursementRepo repo = new ReimbursementRepo();
		List lmao = repo.getReimbursements(user);
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
					"	<h1>Welcome, "+user.getFirstName()+" "+user.getLastName()+"</h1>\r\n"
					+ "<div class='container'><table class='table'>"
						+ "<thead>"
							+ "<tr>"
								+ "<th>Reimbursement ID</th>"
								+ "<th>Amount</th>"
								+ "<th>Time Submitted</th>"
								+ "<th>Time Resolved</th>"
								+ "<th>Resolver</th>"
							+ "</tr>"
						+ "</thead>"
					+ "<tbody></div>";
			for(int i = 0; i < lmao.size(); i++)
				html+= appendTable((Reimbursement) lmao.get(i));
			html+="</tbody></table>";
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.write(html);
		}
	}
	
	private String appendTable(Reimbursement reimb)
	{
		String myString = "";
		switch(reimb.getStatusId())
		{
			case 1: myString += "<tr class='warning'>";break;
			case 2:	myString += "<tr class='success'>";break;
			case 3:	myString += "<tr class='danger'>";break;
			default:break;
		}
		
		myString +=   "<td>"+reimb.getReimbId()+"</td>"
					+ "<td>$"+reimb.getAmount()+"</td>"
					+ "<td>"+reimb.getSubmitted()+"</td>"
					+ "<td>"+reimb.getResolved()+"</td>"
					+ "<td>"+reimb.getResolver()+"</td>";
		
		switch(reimb.getStatusId())
		{
			case 1: myString += "<td>Pending</td></tr>";break;
			case 2:	myString += "<td>Approved</td></tr>";break;
			case 3:	myString += "<td>Denied</td></tr>";break;
			default:break;
		}
		
		return myString;
	}
}