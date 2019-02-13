package com.revature.servelts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class helloservelt extends GenericServlet{
	private static final long serialVersionID = 5429702260507628282L;
	@Override
	public void service(ServletRequest req, ServletResponse res)
		throws ServletException, IOException{
		String text = "Hello World! This is a response from our generic service";
		PrintWriter writer = res.getWriter();
		writer.write(text);
	}
}
