package com.ers.serlvets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.service.ReimbursementService;
import com.ers.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbc.pojos.Reimbursement;
import com.jdbc.pojos.Users;

@WebServlet("/addReimb")
public class AddReimbursementServlet extends HttpServlet {

	UserService uService = new UserService();
	ReimbursementService rService = new ReimbursementService();
	static final Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("Inside do post method in addreimb servlet");
		ObjectMapper mapper = new ObjectMapper();
		
		Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		HttpSession session = req.getSession();
		Users u = (Users) session.getAttribute("user");
		reimb.setAuthor(u.getUserId());
		reimb = rService.addReimbursement(reimb);
		
		resp.setStatus(200);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(new ObjectMapper().writeValueAsString(reimb));
		
		
	}
}
