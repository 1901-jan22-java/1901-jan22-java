package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.pojos.reimbursement;

@WebServlet("/user")
public class UserServlet extends ProjectServlet {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(UserServlet.class);
	static String[] uid_info;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/html");
		StringBuilder htmlResp = new StringBuilder("");
		logger.info("uid: " + uid_info[0] + " | " + "urid: " + uid_info[1]);
		List<reimbursement> rList;
		if(Integer.parseInt(uid_info[1]) == 1) {
			rList = ProjectServlet.dao.get_reimb_for_employee(
					Integer.parseInt(uid_info[0])
			);
		} else {
			rList = ProjectServlet.dao.get_reimb_for_manager();
		}
		
		htmlResp.append(
				"<table class=\"px table\">\r\n" + 
				"	<thead>\r\n" + 
				"		<tr>\r\n" + 
				"			<th scope=\"col\">RID</th>\r\n" + 
				"			<th scope=\"col\">DESC</th>\r\n" + 
				"			<th scope=\"col\">$</th>\r\n" + 
				"			<th scope=\"col\">SUBMITTED</th>\r\n" + 
				"			<th scope=\"col\">STATUS</th>\r\n" + 
				"		</tr>\r\n" + 
				"	</thead>\r\n" + 
				"	<tbody id=\"tbl\">\r\n"
		);
		for(reimbursement r : rList) {
			htmlResp.append(
				"<tr class=\"tblRow\">" +
					"<td>" + r.getRid() + "</td>" +
					"<td>" + r.getDesc() + "</td>" +
					"<td>" + r.getRamount() + "</td>" +
					"<td>" + r.getSubmitted() + "</td>" +
					"<td>" + r.getRstatus() + "</td>" +
				"</tr>"
			);
		}
		htmlResp.append( 
				"	</tbody>\r\n" + 
				"</table><hr>"
		);
		if(Integer.parseInt(uid_info[1]) == 1) {
		htmlResp.append(
				"<div class=\"mx-1 px-1 row\">\r\n" + 
				"<input type=\"hidden\" name=\"uid\" value=" + uid_info[0] + ">" +
				"    <div class=\"col-6\">\r\n" + 
				"         <label>Amount</label>\r\n" + 
				"         <input class=\"form-control\" name=\"amount\" placeholder=\"Enter your Amount\">\r\n" + 
				"    </div>\r\n" + 
				"    <div class=\"col-6\">\r\n" + 
				"      <label>Reimbursement Type</label> <br>\r\n" + 
				"      <select name=\"reimb_type\">\r\n" + 
				"        <option value=\"1\">LODGING</option>\r\n" + 
				"        <option value=\"2\">TRAVELING</option>\r\n" + 
				"        <option value=\"3\">FOOD</option>\r\n" + 
				"        <option value=\"4\">OTHER</option>\r\n" + 
				"      </select>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"  <div class=\"row col-8 ml-3 px-1 my-3\">\r\n" + 
				"    <label>Description</label>\r\n" + 
				"    <input type=\"text\" class=\"form-control\" name=\"desc\" placeholder=\"Enter details pertaining to your reimbursement request\">\r\n" + 
				"  </div>\r\n" + 
				"<div class=\"text-center\">\r\n" + 
				"  <button id=\"new_reimb\" class=\"btn btn-primary btn-lg my-3\">Submit</button>" + 
				"</div>"
				);
		} else {
			htmlResp.append(
					"<input type=\"hidden\" name=\"uid\" value=" + uid_info[0] + ">" +
					"<div class=\"px-5 row\">\r\n" + 
					"    <button  id=\"approve\" type=\"button\" class=\"btn btn-success \">APPROVE</button>\r\n" + 
					"    <button id=\"deny\" type=\"button\" class=\"btn btn-danger mx-5\">DENY</button>\r\n" + 
					"      <label id=\"filter\" class=\"mr-3 mt-1\">Filter:</label> <br>\r\n" + 
					"      <select name=\"filter\">\r\n" + 
					"        <option value=\"*\">ALL</option>\r\n" + 
					"        <option value=\"0\">PENDING</option>\r\n" + 
					"        <option value=\"1\">APPROVED</option>\r\n" + 
					"        <option value=\"2\">DENIED</option>\r\n" + 
					"      </select>\r\n" + 
					"  </div>"
			);
		}
		pw.println(htmlResp.toString());
	}
	
	static void set_uid_info(String str) {uid_info = str.split(",");}
	
}
