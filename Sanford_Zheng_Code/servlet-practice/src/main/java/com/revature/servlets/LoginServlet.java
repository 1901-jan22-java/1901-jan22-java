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
import com.revature.services.UserService;
import com.revature.services.pojos.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 2344344391072246335L;
	private UserService service = new UserService();
	private static Logger log = Logger.getLogger(LoginServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		User u = mapper.readValue(req.getInputStream(), User.class);

		User storedUser = service.getByUsername( u.getUsername() );

		if (storedUser == null) {
			resp.setStatus(404);
		} else if ( !storedUser.getPassword().equals(u.getPassword()) ) {
			resp.setStatus(409);
		} else {
			resp.setStatus(200);
			
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			
			log.info("CREATED SESSION " + session.getId());
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(mapper.writeValueAsString(storedUser));
			
			resp.sendRedirect("home");
		}
	}

	/*
	 * Session Management
	 * 
	 * - A session in an application begins when a user logs in/begins use of the 
	 * application and ends when the user logs out, a period of inactivity ends, 
	 * or the application shuts down.
	 * 
	 * --COOKIES--
	 * - small piece of information persisted between multiple clients requests
	 * - they have names, values and optional attributes
	 * - stored in browser cache
	 * - persisted -- valid for multiple sessions - not removed when browser is
	 * closed, however they can only hold one session.
	 * - javax.servlet.http.Cookie
	 * - Pros: simple, maintained on client side
	 * - Con: cookies can be disabled, text-only
	 * 
	 * --URL Rewriting--
	 * - append identifier to the URL
	 * - Pros: works regardless of cookies being enabled, does not require an extra form
	 * - Cons: text only, only works with the links, not secure
	 * 
	 * --Hidden Form Fields--
	 * - use hidden fields on forms to track user state
	 * 
	 * -- Session Object (HTTP Session) --
	 * - Use the HttpServletRequest.getSession() method to obtain the current session
	 * - if one does not exist, the method will create and return a new one
	 * - sessions have session ID's, last access time, created time and hold objects
	 * identified by a given name.
	 * - invalidate session upon logout.
	 * 
	 */

}