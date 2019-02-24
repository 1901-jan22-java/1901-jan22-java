package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dao.dto.Reimbursement;
import com.revature.ers.dao.dto.User;
import com.revature.ers.dao.pojos.UserData;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.services.UserService;

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6417817436028192843L;
	private static final Logger log = Logger.getLogger(ReimbursementServlet.class);
	private static final ObjectMapper om = new ObjectMapper();
//	private static ReimbursementService rs = new ReimbursementService();

	/**
	 * Gets all reimbursements for testing purposes. Get rid of this when done
	 * testing.
	 * 
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
		log.info(req.getInputStream());

		User u = om.readValue(req.getInputStream(), User.class);
		UserData ud = UserService.getUserData(u.getUsername());
		Integer roleID = ud.getRole_id();

		String json = "";

		if (roleID == 1 || roleID == 3) {
			json = om.writeValueAsString(ReimbursementService.getAllReimbursements());
		} else if (roleID == 2) {
			json = om.writeValueAsString(ReimbursementService.getReimbursements(ud));
		}
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PutParameter param  = om.readValue(req.getInputStream(), PutParameter.class);
		User u = param.user;
		UserData ud = UserService.getUserData(u.getUsername());
		Integer roleID = ud.getRole_id();

		if (roleID == 2) {
			for (Reimbursement r : param.reimbs) {
				ReimbursementService.addReimbursement(r, ud);
			}
		}
	}

	private class PutParameter {
		public User user;
		public Reimbursement[] reimbs;
	}

}
