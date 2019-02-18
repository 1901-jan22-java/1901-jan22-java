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
import com.jdbc.dao.ReimbursementRepository;
import com.revature.reimbursment.Reimbursement;
import com.revature.users.User;

@WebServlet("/reviewReimb")
public class ReviewReimbServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(ReviewReimbServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		log.info(user.getRole());
		if(user.getRole().equalsIgnoreCase("finance manager")) {
			ReimbursementRepository rRepo = new ReimbursementRepository();
			List<Reimbursement> reimbs = rRepo.findAllReimbs();
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(reimbs);
			log.info(json);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(json);
			
		} else {
			resp.setStatus(403);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.write("You do not have access to manager actions.");
			resp.sendRedirect("/home");
		}
	}
}
