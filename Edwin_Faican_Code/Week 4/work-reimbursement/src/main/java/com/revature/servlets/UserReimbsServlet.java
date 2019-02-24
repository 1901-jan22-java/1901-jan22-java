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

@WebServlet("/userReimbs")
public class UserReimbsServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(UserReimbsServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		ReimbursementRepository rRepo = new ReimbursementRepository();
		List<Reimbursement> reimbs = rRepo.findReimbs(user.getUserId());
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbs);
		log.debug(json);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);

	}
}
