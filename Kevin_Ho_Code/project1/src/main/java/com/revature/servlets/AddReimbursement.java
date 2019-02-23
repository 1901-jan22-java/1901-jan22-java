package com.revature.servlets;

import java.io.IOException;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ReimbursementRepo reimbRep = new ReimbursementRepo();
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		reimb.setAuthor(((User)req.getAttribute("sessionUser")).getUserId());
		log.debug(reimb.toString());
		
		resp.setStatus(200);
		resp.sendRedirect("home");
	}
}
