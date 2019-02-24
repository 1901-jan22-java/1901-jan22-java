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

@WebServlet("/approve")
public class ApproveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -352446938014614027L;
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(LoginServlet.class);
	private static final ObjectMapper om = new ObjectMapper();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PostParameters param  = om.readValue(req.getInputStream(), PostParameters.class);
		User u = param.user;
		UserData ud = UserService.getUserData(u.getUsername());
		Integer roleID = ud.getRole_id();

		if(roleID==1 || roleID == 3) {
			
		}
	}
	
	private class PostParameters {
		public User user;
		public Reimbursement[] reimbs;
	}
	
}
