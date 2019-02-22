package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/test")
public class TestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		/**
		 * One common way to wrtie responses to our requests
		 * is to use the PrintWriter object.
		 * This prints formatted representations of objects to a 
		 * text-output stream. This class implements all of the print mehtods
		 * found in PrintStrem.
		 */
		
		PrintWriter pw = resp.getWriter();
		pw.write("in test servlet");
	
	}

}
