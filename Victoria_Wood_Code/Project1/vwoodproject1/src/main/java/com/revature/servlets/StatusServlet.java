package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
	UserService uService = new UserService();
	Logger log = Logger.getLogger(StatusServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("IN STATUS SERVLET");
		Map<Reimbursement, User> reimbs = uService.filterByStatus("Pending");
		PrintWriter writer = resp.getWriter();
		String html;
		if(reimbs.isEmpty()) {
			html = "<h2>There are no pending requests </h2>"
					+ "<br> <span id=\"menu\"> Click here to return to Reimbursements History</span>";
		} else {
			html = "<div class=\"jumbotron\">\n"
					+ "<h3> Select which request you would like to approve or deny: </h3> <br>";
			for(Map.Entry<Reimbursement, User> entry : reimbs.entrySet()) {
				Reimbursement r = entry.getKey();
				User u = entry.getValue();
				html += "<input type=\"radio\" name=\"choice\" value=" + r.getId() + ">"
						+ r.getId() + " $" + r.getAmount() + " " + r.getDescription() + " " +r .getType() + " " + u.getLn() + "<br>";
			}
			html += "<br> <button class=\"btn btn-success\" style=\"padding: 5; border: 5; margin-right: 10\" id=\"approve\">Approve</button>"
					+ "<span>  </span>"
					+ "<button class=\"btn btn-danger\" style=\"padding: 5; border: 5; margin-left: 10; align: center\" id=\"deny\">Deny</button> <br><br>"
					+ "<span id=\"viewAll\"> To return to reimbursement history click here </span>"
					+ "</div>";
		}
		resp.setContentType("text/html");
		writer.write(html);
	}
	
	@Override protected void doPost(HttpServletRequest req, HttpServletResponse
			resp) throws ServletException, IOException {
		log.trace("IN UPDATE SERVLET"); 
		HttpSession session =req.getSession(false); 
		User u = (User) session.getAttribute("sessionUser");

		ObjectMapper mapper = new ObjectMapper(); 
		Reimbursement r = mapper.readValue(req.getInputStream(), Reimbursement.class);
		log.trace("R_ID: " + r.getId() + " Status_Id: " + r.getStatus_id());

		boolean updated = uService.changeStatus(u, r.getId(), r.getStatus_id());

		PrintWriter writer = resp.getWriter(); String html;

		if(!updated) { html = "<div class=\"jumbotron\">" +
				"<h2>Update was unsuccessful</h2>" +
				"<span id=\"home\" class=\"btn btn-submit\"> Click here to return to Main Menu</span>"
				+ "</div>";

		} else { html = "<div class=\"jumbotron\">" +
				"<h2>Update was successful</h2>" +
				"<span id=\"home\" class=\"btn btn-submit\"> Click here to return to Main Menu</span>"
				+ "</div>"; } resp.setContentType("text/html"); writer.write(html); 
	}

	
}
