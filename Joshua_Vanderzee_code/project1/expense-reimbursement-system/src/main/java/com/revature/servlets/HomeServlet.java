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
import com.revature.jdbc.dao.ErsFactory;
import com.revature.jdbc.pojos.Ers;
import com.revature.jdbc.pojos.ErsReimbursement;
import com.revature.jdbc.pojos.ErsUser;

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
		HttpSession session = req.getSession();
		Ers user = (Ers)session.getAttribute("sessionUser");
		dataInfo filter = mapper.readValue(req.getInputStream(), dataInfo.class);		
		log.info(filter.homeType);
		ErsFactory.getAllReimbursements(user);
		String json = "[";
		for (int i = 0; i <= user.lastReimbursement(); i++) {
			json += mapper.writeValueAsString(user.getReimbursementByID(i));
			if (i < user.lastReimbursement())
				json += ",";
		}
		json += "]";
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}
}

class dataInfo {
    String homeType;
    int page;
    String filter;
    
    public dataInfo() { }

	public String getHomeType() {
		return homeType;
	}

	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

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