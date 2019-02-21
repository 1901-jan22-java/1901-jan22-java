package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestServlet extends HttpServlet{
	
	Logger log = Logger.getLogger(TestServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ObjectMapper mapper = new ObjectMapper();
		log.info("Servlet log request");
		PrintWriter pw = resp.getWriter();
		pw.println("In test Servlet");
	}
	
}
