package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/*
	 * Session Management 
	 * 
	 * - A session in an application begins when a user 
	 * logs in/begins use of the application and ends 
	 * when the user logs out, a period of inactivity ends, 
	 * or the application shuts down 
	 * 
	 * --Cookies--
	 * - small piece of information persisted between 
	 * multiple client requests 
	 * - they have names, values, and optional attributes 
	 * - stored in browser cache 
	 * - persistent -- valid for multiple sessions - not 
	 * removed when browser is closed, however they can only
	 * hold one session 
	 * - javax.Servlet.http.Cookie
	 * - Pros: simple, maintained on client side
	 * - Con: cookies can be disabled, text-only 
	 * 
	 * 
	 * --URL Rewriting-- 
	 * - append identifier to the URL 
	 * - Pros: works regardless of cookies being enabled, 
	 * does not require an extra form 
	 * - Cons: text only, only works with links, not secure
	 * 
	 * --Hidden Form Fields-- 
	 * - use hidden fields on forms to track user state
	 *
	 * -- Session Object (HttpSession)
	 * - Use the HttpServletRequest.getSession() method to 
	 * obtain the current session 
	 * - if one does not exist, the method will create and 
	 * return a new one 
	 * - sessions have session ID's, last accessed time, 
	 * created time and hold objects identified by a given name
	 * - invalidate session upon logout. 
	 * 
	 */
	
	DummyUserService service = new DummyUserService();
	static final Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		User u = mapper.readValue(req.getInputStream(), User.class);
		
		User storedUser = service.getByUsername(u.getUsername());
		if(storedUser == null) {
			resp.setStatus(418);
			
		} else if(storedUser.getPassword().equals(u.getPassword())) {
			//user is logged in
			resp.setStatus(200);
			
			//manage session
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			log.info("CREATED SESSION " + session.getId());
			
			// if we want user info immediately, do this
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(mapper.writeValueAsString(u));
		} else {
			resp.setStatus(418);
		}
	}
}

	