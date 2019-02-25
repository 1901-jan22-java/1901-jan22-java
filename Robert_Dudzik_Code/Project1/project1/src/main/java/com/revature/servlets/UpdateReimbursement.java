package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

import org.apache.log4j.Logger;


@WebServlet("/updateReim")
public class UpdateReimbursement extends HttpServlet
{
	private static Logger log = Logger.getLogger(UpdateReimbursement.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
        ObjectMapper mapper = new ObjectMapper();
        
        Reimbursement r = mapper.readValue(req.getInputStream(), Reimbursement.class);
        User u = (User)req.getSession().getAttribute("sessionUser");
        if(u.findSpecificReim(r.getId()))
        {
            log.info("Found Reimbursement ID");
            Reimbursement reim = u.getSpecificReim(r);
            reim.setResolverId(u.getId());
            reim.setStatus(r.getStatus());
            reim.setStatusId(r.getStatusId());
           
            log.info("Reimbursement ID " + reim.getId());
            reim = reim.updateReimbursement();
            if(reim != null)
            {
                log.info("Successfully Updated Reimbursement");
                u.updateSpecificReimbursement(reim);
                resp.setStatus(200);
                req.getSession().setAttribute("sessionUser", u);
            }
        }

	}
}