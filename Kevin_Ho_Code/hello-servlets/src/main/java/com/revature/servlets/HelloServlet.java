/**
 * 
 */
package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

/**
 * @author Kevin's MemeMachine
 *
 */
public class HelloServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5429702260507628282L;
	private static Logger log = Logger.getLogger(HelloServlet.class);
	static int requestCount = 0;
	
	/* first method of servlet lifecycle
	 * here is where we initialize the servlet, potentially with servlet variables or special logging functionality
	 * should always call super.init() first
	 * 
	 * this init method is called by default before
	 * the first request to this servlet, however with the
	 * <load-on-startup> tag (or property if using annotations), we 
	 * can configure our servlets to be initialized upon startup
	 * of our container (Tomcat)
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		log.trace("Initializing HelloServlet");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//SERVICE METHOD INSIDE OF A GENERICSERVLET MUST BE OVERRIDDEN
		log.trace("Servicing things");
		//get servlet context and config info
		String context = getServletContext().getInitParameter("envVar");
		String config = getServletConfig().getInitParameter("secret");
		
		String text = "<h1>HELLO WORLD!</h1>"
					+	"<br>This is a response from our generic servlet!"
					+	"<br><hr><br><li>Request #" + ++requestCount
					+	"<li>Servlet Context: " + context + 
						"<li>Servlet Config: " + config;
		
		//PrintWriter - used to write text responses
		PrintWriter writer = res.getWriter();
		
		
		writer.write(text);
	}

	/*
	 * last method in the servlet lifecycle,
	 * */
	@Override
	public void destroy() {
		super.destroy();
		log.trace("Destroying Hello World");
	}
}
