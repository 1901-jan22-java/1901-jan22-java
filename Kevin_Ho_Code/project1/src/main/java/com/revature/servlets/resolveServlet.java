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

@WebServlet("/resolve")
public class resolveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log =  Logger.getLogger(resolveServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("resolving servlet");
		
		HttpSession session = req.getSession();
		ReimbursementRepo reimbRep = new ReimbursementRepo();
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		
		if(reimbRep.getReimbById(reimb.getReimbId()).getSubmitted() == null)
		{
			resp.setStatus(401);
			log.debug(reimb.toString());
		}
		else
		{
			User u = (User)session.getAttribute("sessionUser");
			reimb.setResolver(u.getUserId());
			reimbRep.resolve(reimb);
			resp.setStatus(201);
			log.debug(reimbRep.resolve(reimb).toString());
		}
		resp.sendRedirect("home");
	}

}
