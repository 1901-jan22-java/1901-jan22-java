package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/myHTTP")
public class MyHTTPServlet extends HttpServlet {

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(MyHTTPServlet.class);
	
	private static final long serialVersionUID = -7201933054284569968L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		PrintWriter writer = resp.getWriter();
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
		
		writer.write("RAND");
	}
	
	
}
