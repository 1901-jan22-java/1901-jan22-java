package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/managermenu/*")
public class ManagerServlet extends HttpServlet{
	
	UserService uService = new UserService();
	Logger log = Logger.getLogger(ManagerServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("IN MANAGER SERVLET");
		String pathInfo = req.getPathInfo();
		log.info("GET: /managermenu" + (pathInfo == null ? "" : pathInfo));
		
		Map<Reimbursement,User> reimbs;
		if(pathInfo == null || pathInfo.trim().contentEquals("/")) {
			reimbs = uService.viewAll();
		} else {
			String status = pathInfo.trim().substring(1);
			reimbs = uService.filterByStatus(status);
		}
		
		PrintWriter writer = resp.getWriter();
		String html;
		
		if(reimbs.isEmpty()) {
			html = "<h2> No Reimbursement History is Available </h2>"
					+ "<span id=\"viewAll\">Click here to return to see all reimbursments </span>";
		} else {
			html = "<div class=\"jumbotron\">\r\n"
					+ "<br> To view by status: "
					+ "<select id=\"status\">"
					+ "		<option value=\"Pending\">Pending</option>"
					+ "		<option value=\"Approved\">Approved</option>"
					+ "		<option value=\"Denied\">Denied</option>"
					+ "</select>"
					+ "<button id=\"byStatus\" class=\"btn btn-primary\">Enter</button>"
					+ "<br> <br> <span id=\"changeStatus\" style=\"text-align: left\" class=\"btn btn-warning\"> To approve or deny requests click here</span><br><br>"
					+ "<h3> Showing Reimbursement History for all Employees</h3>"
					+ "<br><table id=\"myTable\">"
					+ "         <thead>"
					+ "             <tr>"
					+ "					<th>Reimbursement</th>"
					+ "					<th>Amount Requested</th>"
					+ "					<th>Date Submitted</th>"
					+ "					<th>Date Resolved</th>"
					+ "					<th>Resolver ID</th>"
					+ "					<th>Description</th>"
					+ "					<th>Type</th>"
					+ "					<th>Status</th>"
					+ "					<th>Employee ID </th>"
					+ "					<th>Name</th>"
					+ "					<th>Role</th>"
					+ "				</tr>"
					+ "			</thead>"
					+ "			<tbody>";
			for(Map.Entry<Reimbursement, User> entry : reimbs.entrySet()){
				Reimbursement r = entry.getKey();
				User u = entry.getValue();
					html += "            <tr>" + 
							"                <td>" + r.getId() + "</td>" + 
							"                <td>" + r.getAmount() + "</td>" +
							"                <td>"+ r.getSubmitted() + "</td>" + 
							"                <td>" + r.getResolved() + "</td>" +
							"                <td>" + r.getResolver() + "</td>" +
							"				 <td>" + r.getDescription() +"</td>" +
							"                <td>" + r.getType() + "</td>" +
							"                <td>" + r.getStatus() + "</td>" +
							"                <td>" + u.getId() + "</td>" +
							"                <td>" + u.getFn() + " " + u.getLn() + "</td>" +
							"                <td>" + u.getRole() +"</td>" +
							"            </tr>";
				}
			html +=	"  </tbody>\r\n" + 
					"    </table>"
					+ "<br> <span id=\"home\" class=\"btn btn-submit\">To return to Main Menu press here</span>";
		}
		resp.setContentType("text/html");
		writer.write(html);

	}
	
	
	
}
