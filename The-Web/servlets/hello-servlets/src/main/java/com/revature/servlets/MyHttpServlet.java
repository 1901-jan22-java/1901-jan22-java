package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/myHttp")
public class MyHttpServlet extends HttpServlet{

	/*
	 * HttpServlet extends GenericServlet, meaning they
	 * have the same init, service, destroy lifecycle but 
	 * just do things a bit differently to be comply with
	 * HTTP. 
	 * 
	 * Here, we do NOT have to override the service() method, 
	 * we must simply override AT LEAST ONE do[verb] methods
	 * such as doGet(), doPost(), doPut(), etc/
	 */
	
	private static Logger log = Logger.getLogger(MyHttpServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
		writer.write("this is text from our http servlet");
		
	}
	
}
