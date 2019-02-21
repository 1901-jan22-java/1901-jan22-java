package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws 
			ServletException, IOException{
		/*
		 * One common way to write responses to our
		 * requests is to use the PrintWriter object.
		 * This prints formatted representations of 
		 * objects to a text-output stream. This class
		 * implements all of the print methods found in 
		 * PrintStream. 
		 */
		PrintWriter pw = resp.getWriter();
		pw.write("in test servlet");
		
		/*
		 * Retrieving info about the application 
		 * https://www.oreilly.com/library/view/java-servlet-programming/0596000405/ch04.html
		 */
	}
		
}
