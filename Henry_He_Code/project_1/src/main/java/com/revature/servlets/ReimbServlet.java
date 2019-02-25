package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/reimb")
public class ReimbServlet extends ProjectServlet {
	
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] rData = req.getReader().readLine().split(",");
		logger.info(rData[0] +","+ rData[1] +","+ rData[2] +","+ rData[3] +","+ rData[4]);
		StringBuilder htmlResp = new StringBuilder("");
		int key = ProjectServlet.dao.new_reimbursement(
			Double.parseDouble(rData[1]),
			rData[3],
			Integer.parseInt(rData[0]),
			Integer.parseInt(rData[2])
		);
		if(key > 0) {
			resp.setStatus(200);
			
			htmlResp.append(
					"<tr class=\"tblRow\">" +
							"<td>" + key + "</td>" +
							"<td>" + rData[3] + "</td>" +
							"<td>" + rData[1] + "</td>" +
							"<td>" + rData[4] + "</td>" +
							"<td>PENDING</td>" +
						"</tr>"
			);
			resp.getWriter().println(htmlResp.toString());
		} else resp.setStatus(401);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] put_data = req.getReader().readLine().split(",");
		int approval = Integer.parseInt(put_data[0]);
		int granter_id = Integer.parseInt(put_data[1]);
		boolean approved = ( Integer.parseInt(put_data[0]) == 1);
		for(int i=2; i<put_data.length; i++) {
			ProjectServlet.dao.update_reimbursement(granter_id, Integer.parseInt(put_data[i]), approved);
		}
	}
}
