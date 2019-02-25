package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

@WebServlet("/addReim")
public class AddReimbursement extends HttpServlet
{
	private static Logger log = Logger.getLogger(AddReimbursement.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		//System.out.println("Were here in Add Reimbursement");
		HttpSession session = req.getSession();
		//System.out.println(session.getId());
		User user = (User)session.getAttribute("sessionUser");
		log.info(user.getId() + " " + user.getUsername());
		
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reim = mapper.readValue(req.getInputStream(), Reimbursement.class);
		reim.setStatusId(1);
		reim.setAuthorId(user.getId());
		log.info(reim.getAmount());
		reim = reim.addReimbursementToDB();
		if(reim == null)
		{
			log.info("Reimbursement unsuccessfull");
			resp.setStatus(418);
		}
		else  
		{
			log.info("Reimbursement successfully added to DB");
			resp.setStatus(230);
			user.addReimbursement(reim);
			session.setAttribute("sessionUser", user);
		}
	}
}
