package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.BiMap;
import com.revature.ers.dao.dto.ResolveReimbursementParameters;
import com.revature.ers.dao.pojos.UserData;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.services.UserService;

@WebServlet("/deny")
public class DenyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5436274835900903102L;
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(LoginServlet.class);
	private static final ObjectMapper om = new ObjectMapper();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ResolveReimbursementParameters param  = om.readValue(req.getInputStream(), ResolveReimbursementParameters.class);
		UserData ud = UserService.getUserData(param.getResolver().getUsername());
		Integer roleID = ud.getRole_id();
		Integer[] reimbIDs = param.getReimbs();
		BiMap<String, Integer> rolesMap = UserService.getRoles().inverse();

		if(roleID==rolesMap.get("Admin") || roleID == rolesMap.get("Finance Manager")) {
			ReimbursementService.deny(reimbIDs, ud);
		}
		
		resp.setContentType("application/json");
		resp.getWriter().write(om.writeValueAsString(ReimbursementService.getAllReimbursements()));
	}

}
