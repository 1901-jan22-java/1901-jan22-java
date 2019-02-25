package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

@WebServlet("/getReim")
public class GetReimbursements extends HttpServlet
{
	private static Logger log = Logger.getLogger(GetReimbursements.class);
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("sessionUser");
        String json = "[";
        if(user.getRoleId() == 1)//Employee
        {
            for(int i = 0; i < user.getReimbursements().size(); i++)
            {
                String temp = mapper.writeValueAsString(user.getSpecificReim(i));
                json += temp;
                if(i != user.getReimbursements().size() - 1)
                {
                    json += ", ";
                }
            }
            json += "]";
            resp.setContentType("application/json");
            resp.getWriter().write(json);
        }    
        else//Manager
        {
            for(int i = 0; i < user.getReimbursements().size(); i++)
            {
                String temp = mapper.writeValueAsString(user.getSpecificReim(i));
                json += temp;
                if(i != user.getReimbursements().size() - 1)
                {
                    json += ", ";
                }
            }
            json += "]";
            resp.setContentType("application/json");
            resp.getWriter().write(json);
        }
    }
}
