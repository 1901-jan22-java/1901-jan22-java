package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dpr.DtrReParam;
import com.revature.dpr.DprReimbursement;
import com.revature.dpr.DprUser;
import com.revature.pojos.UserData;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

@WebServlet("/reimbursement")
public class ServletReimbursement extends HttpServlet {
	private static final long serialVersionUID = 6417817436028192843L;
	private static final Logger log = Logger.getLogger(ServletReimbursement.class);
	private static final ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String json = om.writeValueAsString(ReimbursementService.getAllReimbursements());
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info(req.getInputStream());

		DprUser u = om.readValue(req.getInputStream(), DprUser.class);
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

		DtrReParam param = om.readValue(req.getInputStream(), DtrReParam.class);
		UserData ud = UserService.getUserData(param.getAuthor().getUsername());
		Integer roleID = ud.getRole_id();

		if (roleID == UserService.getRoleID("Employee")) {
			for (DprReimbursement r : param.getReimbs()) {
				ReimbursementService.addReimbursement(r, ud);
			}
		}
		resp.setContentType("application/json");
		resp.getWriter().write(om.writeValueAsString(ReimbursementService.getReimbursements(ud)));
	}
}
