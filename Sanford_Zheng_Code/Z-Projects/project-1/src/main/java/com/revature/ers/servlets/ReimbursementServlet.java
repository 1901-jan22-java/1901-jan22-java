package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.services.ReimbursementService;

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6417817436028192843L;
	private static final ObjectMapper om = new ObjectMapper();
//	private static ReimbursementService rs = new ReimbursementService();

	/**
	 * Gets all reimbursements
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = om.writeValueAsString(ReimbursementService.getAllReimbursements());
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}
	
	
	/**
	 * Add a new reimbursement from request
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String json = om.writeValueAsString(ReimbursementService.getAllReimbursements());
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}
	
}
