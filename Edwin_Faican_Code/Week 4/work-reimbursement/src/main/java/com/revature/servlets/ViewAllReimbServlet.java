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

@WebServlet("/viewAll")
public class ViewAllReimbServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(ViewAllReimbServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter writer = resp.getWriter();
		
		
		if(user.getRole().equalsIgnoreCase("Finance Manager")) {
			List<Reimbursement> reimbs = (new ReimbursementRepository()).findAllReimbs();
			String json = mapper.writeValueAsString(reimbs);
			resp.setContentType("application/json");
			writer.write(json);
		} else {
			resp.setStatus(403);
			resp.setContentType("text/html");
			writer.write("You are not authorized to view this data.");
		}
	}
}
