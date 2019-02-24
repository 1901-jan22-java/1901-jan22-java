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
import com.jdbc.dao.ReimbursementRepository;
import com.revature.reimbursment.Reimbursement;
import com.revature.users.User;

@WebServlet("/addReimb")
public class AddReimbServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(AddReimbServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		log.info(user.toString());
		ReimbursementRepository rRepo = new ReimbursementRepository();
		ObjectMapper  mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		reimb.setAuthor(user.getUserId());
		log.info(reimb.getAuthor() + " " + reimb.getDesc() + reimb.getType() + reimb.getReimbAmount());
		
		PrintWriter writer = resp.getWriter();
		if((reimb.getReimbAmount() + " ").contains("-")) {
			resp.setStatus(400);
			writer.write("Invalid amount.");
		} else {
			reimb = rRepo.newReimb(reimb);
			
			String json = mapper.writeValueAsString(reimb);
			
			resp.setStatus(201);
			
			
			resp.setContentType("application/json");
			writer.write(json);
		}
		
	}
}
