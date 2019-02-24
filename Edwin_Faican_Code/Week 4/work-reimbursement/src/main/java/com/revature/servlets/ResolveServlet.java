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
import com.jdbc.dao.ReimbursementRepository;
import com.revature.reimbursment.Reimbursement;
import com.revature.users.User;

@WebServlet("/resolve")
public class ResolveServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(ResolveServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursementRepository rRepo = new ReimbursementRepository();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		reimb.setResolver(user.getUserId());
		reimb = rRepo.resolve(reimb);
		
		resp.setStatus(200);
	}
}
