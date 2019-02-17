package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourcesServlet extends HttpServlet {

	/**
	 * Auto-Generated serialVersionUID
	 */
	private static final long serialVersionUID = -1011413864455738089L;
	
	/*
	 * With servlets, we may not always want to simply return some information as text,
	 * we may want to navigate to a different servlet, or to forward a resource(html, jsp,
	 * etc) as a response
	 * 
	 * There are two ways to move between our resources:
	 *  - Forward - client send s a request to server with a URL /a. Servlet forwards the same
	 *  	req/resp pair to a servlet B. but the client is unaware of this as the path is still
	 *  	/a when response gets returned
	 *  	- Original req/resp pair gets returned,
	 *  	- URL does not change
	 *  	- req.get RequestDispatcher.forward();
	 *  - Redirect - client sends a request /a. servlet responds with a status code of 300-399 and
	 *  	instructions to send a new quest to /b. client sends a request to /b and the client path
	 *  	is now at /b
	 *  	- in sum, we see a url change for client, good for lo(??)
	 *  	- new req/resp pair
	 *  	- resp.sendRedirect()
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		super.doGet(req, resp);
	}
}
