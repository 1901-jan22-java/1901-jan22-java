package com.revature.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.Reimbursement;
import com.revature.reimbursement.ReimbursementRepo;
import com.revature.user.User;

@WebServlet("/addReimb")
public class AddReimbursement extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Logger log =  Logger.getLogger(AddReimbursement.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("in addreimb");
		
		HttpSession session = req.getSession();
		ReimbursementRepo reimbRep = new ReimbursementRepo();
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		
		User u = (User)session.getAttribute("sessionUser");
		reimb.setAuthor(u.getUserId());
		reimb.setSubmitted(new Timestamp(System.currentTimeMillis()));
		reimb.setStatusId(1);
		log.debug(reimb.toString());
		
		if(reimbRep.addReimb(reimb).getReimbId() != 0)
			resp.setStatus(200);
		else
			resp.setStatus(500);
		
		if(u.getRoleId() == 0)
			resp.sendRedirect("home");
		else
			resp.sendRedirect("managerHome");
	}
}
