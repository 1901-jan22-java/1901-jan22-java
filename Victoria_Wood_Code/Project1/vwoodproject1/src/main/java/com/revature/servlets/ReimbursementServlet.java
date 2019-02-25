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
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/reimbursements")
public class ReimbursementServlet extends HttpServlet{
	UserService uService = new UserService();
	Logger log = Logger.getLogger(ReimbursementServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("sessionUser");
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement info = mapper.readValue(req.getInputStream(), Reimbursement.class);
		PrintWriter writer = resp.getWriter();
		log.trace("IN REIMBURSEMENT SERVLET");
		log.trace("Reimbursement info: " + info.toString());
		Reimbursement r = uService.addReimb(u, info.getAmount(), info.getDescription(), info.getType_id());
		log.trace(r);
		if(r == null) {
			resp.setStatus(418);
			log.trace("No Reimbursement Created");
			String html = "<div class=\"jumbotron\">"
					+ "<h2> Your Reimbursement Request was unsuccessful</h2>"
					+ "<span id=\"menu\"> Click Here to Return to Main Menu </span>"
					+ "</div>";		
			resp.setContentType("text/html");
			writer.write(html);
		} else {
			resp.setStatus(200);
			log.trace("Reimbursement Request Successful");
			String html = "<div class=\"jumbotron\">"
					+ "<h2> Your Reimbursment Request was successful.</h2>"
					+ "<span id=\"menu\"> Click Here to Return to Main Menu </span>"
					+ "</div>";
			resp.setContentType("text/html");
			writer.write(html);
		}
	}
}
