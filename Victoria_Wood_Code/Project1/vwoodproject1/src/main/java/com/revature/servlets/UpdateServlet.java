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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	UserService uService = new UserService();
	Logger log = Logger.getLogger(UpdateServlet.class);

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
