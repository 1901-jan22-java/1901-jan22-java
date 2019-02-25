package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import org.apache.log4j.Logger;

@WebServlet("/login")
public class LogInServlet  extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3054767034092711781L;
	//UserService service = new UserService();
	private static Logger log = Logger.getLogger(LogInServlet.class);
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        User u = mapper.readValue(req.getInputStream(), User.class);
        User n = u.checkUser(u.getUsername(), u.getPassword());
        log.info("Entered Log In Method");
		if(n == null)
		{
            resp.setStatus(418);
            log.info("Username & Password combo not found");
		}
		else 
		{
			if(n.getRoleId() == 1)//Employee
			{
				resp.setStatus(230);
				n = n.getAllUserReimbursements();
			}
			else  //Manager
			{
				resp.setStatus(231);
				n = n.getAllReimbursements();
			}
			HttpSession session = req.getSession();
			session.setAttribute("sessionUser", n);
			log.info("Created Session: " + session.getId());
		}
	}
}
