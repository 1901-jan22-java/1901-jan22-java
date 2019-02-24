package com.revature.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


//@WebServlet("/test")
public class TestServlet extends HttpServlet{
	public static Logger log = Logger.getLogger(TestServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		writer.write("In test servlet! Bonjour! The time of access is: " + new Date().toString());
		log.info("WE HAVE DONE IT MATES!");
	}
}
