package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.users.User;

@WebServlet("*.view")
public class LoadViewServlets extends HttpServlet {
	public static Logger log = Logger.getLogger(LoadViewServlets.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "views/" + process(req,resp) + ".html";
		log.info(resourcePath);
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}


	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		String[] uri = req.getRequestURI().split("/");
		String resource = uri[uri.length-1];
		return 	resource.substring(0, resource.length()-5);
	}
}
