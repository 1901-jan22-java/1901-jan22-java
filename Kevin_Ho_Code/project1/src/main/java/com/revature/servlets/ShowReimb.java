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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.Reimbursement;
import com.revature.reimbursement.ReimbursementRepo;
import com.revature.user.User;

@WebServlet("/showReimb")
public class ShowReimb extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static Logger log =  Logger.getLogger(ShowReimb.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursementRepo reimbRepo = new ReimbursementRepo();
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("sessionUser"); 
		List<Reimbursement> reimbList = reimbRepo.getReimbursements(user);
		
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimbList);
		resp.setContentType("application/json");
		writer.write(json);
		
	}
}
