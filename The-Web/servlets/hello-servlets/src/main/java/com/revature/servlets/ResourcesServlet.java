package com.revature.servlets;

<<<<<<< HEAD
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
=======
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resource")
public class ResourcesServlet extends HttpServlet{
/*
With servlets, we may not always want to simply 
return some information as text, we may want to
navigate to a different servlet, or to forward a 
resource(html, jsp, etc) as a response 

There are two ways to move between our resources:
Forward - client sends a request to server with a 
    URL /a. Servlet forwards the same req/resp pair
    to a servlet B. but the client is unaware of this
    as the path is still /a when response gets returned
    - original req/resp pair gets retuned, 
    - URL does not change 
    - req.getRequestDispatcher.forward();
    - the RequestDispatcher is an interface whose 
    implementation defines an object which can dispatch the 
    request to any resources on the server 
Redirect - client sends a request /a. servlet responds with 
    a status code of 300-399 and instructions ot send a 
    new request to /b. client sends a request to /b and 
    the client path is now at /b 
    - in sum, we see a url change for client, good for login
    - new req/resp pair 
    - resp.sendRedirect();
*/
	
	
    
//FORWARDS 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("resource.html").forward(req, resp);
	}
	
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doPost(req, resp);
		}
	

}
>>>>>>> master
