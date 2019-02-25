package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.jdbc.pojos.Ers;
import com.revature.services.ErsService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		log.trace("In home servlet retrieved session " + session.getId());
		Ers user = (Ers)session.getAttribute("sessionUser");
		if (user == null)
		{
			resp.sendRedirect("login");
		}
		else
		{
			if (user.isFinancialManager())
			{
				resp.sendRedirect("finance-home.view");
			}
			else
			{
				resp.sendRedirect("employee-home.view");
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ErsService es = new ErsService();
		HttpSession session = req.getSession();
		Ers user = (Ers)session.getAttribute("sessionUser");
		if (user != null)
		{
			dataInfo filter = mapper.readValue(req.getInputStream(), dataInfo.class);
			if (filter.getFilter() != null) {
				if (filter.filter.equals("All"))
				{
					if (user.isFinancialManager())
						es.getAllReimbursements(user, com.revature.services.status.all);
					else
						es.findAllReimbursements(user, com.revature.services.status.all);
				}
				else if (filter.filter.equals("Pending"))
				{
					if (user.isFinancialManager())
						es.getAllReimbursements(user, com.revature.services.status.pending);
					else
						es.findAllReimbursements(user, com.revature.services.status.pending);
				}
				else if (filter.filter.equals("Resolved"))
				{
					if (user.isFinancialManager())
						es.getAllReimbursements(user, com.revature.services.status.resolved);
					else
						es.findAllReimbursements(user, com.revature.services.status.resolved);
				}
			}
			else
			{
				resp.setStatus(303);
			}
			String json = mapper.writeValueAsString(user);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(json);
		}
		else
		{
			resp.setStatus(406);
			PrintWriter writer = resp.getWriter();
			writer.write("Not logged in");
		}
	}
}

class dataInfo {
    int page;
    String filter;
    
    public dataInfo() { }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
}