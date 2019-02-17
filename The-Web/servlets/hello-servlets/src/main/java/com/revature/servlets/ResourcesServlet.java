package com.revature.servlets;

import javax.servlet.http.HttpServlet;

public class ResourcesServlet extends HttpServlet{
	/*
	 * With Servlets, we may not always want to simply return some information as text, we may want to navigate to a different servlet,
	 *  or forward a resource as a response.
	 *  
	 *  There are two ways to move between our resources:
	 *  Forward - client sends a request to server with a URL /a
	 *  Servlet forwards the same req/resp pair to a servlet B, but the client is unaware of this
	 *  as the path is still /a when response gets returned
	 *  
	 *  Redirect - client sends a request /a. servlet repsonds with a status code of 300-399 and instructioins to send a new request
	 *  to /b. client sends a request to /b and the client pathi is now at /b
	 *  
	 *  in Sum, we see a url change for client, good for logic
	 *  new req/resp pair
	 *  resp.sendRedirect();
	 */
	
	
}
