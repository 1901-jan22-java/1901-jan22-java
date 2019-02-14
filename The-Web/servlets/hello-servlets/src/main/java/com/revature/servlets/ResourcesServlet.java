package com.revature.servlets;

import javax.servlet.http.HttpServlet;

public class ResourcesServlet extends HttpServlet {
	
	/*
	 * With servlets, we may not always want to simply return some information as
	 * text, we may want to navigate to a different servlet, or to forward a
	 * resource(html, jsp, etc) as a response
	 * 
	 * There are two ways to move between our resources: Forward - client sends a
	 * request to server with a URL /a. Servlet forwards the same req/resp pair to a
	 * servlet B. but the client is unaware of this as the path is still /a when
	 * response gets returned - original req/resp pair gets retuned, - URL does not
	 * change - req.getRequestDispatcher.forward(); Redirect - client sends a
	 * request /a. servlet responds with a status code of 300-399 and instructions
	 * ot send a new request to /b. client sends a request to /b and the client path
	 * is now at /b - in sum, we see a url change for client, good for login - new
	 * req/resp pair - resp.sendRedirect();
	 */

}