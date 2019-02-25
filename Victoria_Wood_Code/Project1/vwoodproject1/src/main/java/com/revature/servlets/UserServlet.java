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

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/menu")
public class UserServlet extends HttpServlet{
	UserService uService = new UserService();
	Logger log = Logger.getLogger(UserServlet.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("sessionUser");
		log.trace("IN USERSERLVET. RETRIEVED SESSION " + session.getId());
		List<Reimbursement> reimbs = uService.getReimb(u.getId());
		PrintWriter writer = resp.getWriter();
		String html;
		if(reimbs.isEmpty()) {
			html = "<h2> You have no history of Reimbursement Requests </h2>"
					+ "<h4>Return to the <span id=\"home\" class=\"btn btn-submit\">Main Menu </span> to make a Reimbursement Request</h4>";
		} else {
			html = "<div class=\"jumbotron\">\r\n"
					+ "<h3> Showing Reimbursement History for " + u.getFn() + " " + u.getLn() + "</h3>"
					+ "<br><table id=\"myTable\">"
					+ "         <thead>"
					+ "             <tr>"
					+ "					<th>Reimbursement</th>"
					+ "					<th>Amount Requested</th>"
					+ "					<th>Date Submitted</th>"
					+ "					<th>Date Resolved</th>"
					+ "					<th>Description</th>"
					+ "					<th>Type</th>"
					+ "					<th>Status</th>"
					+ "				</tr>"
					+ "			</thead>"
					+ "			<tbody>";
			for(Reimbursement r: reimbs) {
				html += "            <tr>" + 
						"                <td>" + r.getId() + "</td>" + 
						"                <td>" + r.getAmount() + "</td>" +
						"                <td>"+ r.getSubmitted() + "</td>" + 
						"                <td>" + r.getResolved() + "</td>" +
						"				 <td>" + r.getDescription() +"</td>" +
						"                <td>" + r.getType() + "</td>" +
						"                <td>" + r.getStatus() + "</td>" +
						"            </tr>";
			}
			html +=	"  </tbody>\r\n" + 
					"    </table>"
					+ "<br> <span id=\"home\" class=\"btn btn-submit\">To return home press here</span>";
		}
		
		resp.setContentType("text/html");
		writer.write(html);
	}

}
