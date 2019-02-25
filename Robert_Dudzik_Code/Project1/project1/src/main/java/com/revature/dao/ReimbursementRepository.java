package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementRepository 
{

    public ReimbursementRepository() { }

    public Reimbursement addReimbursement(Reimbursement reim)
    {
        Reimbursement results = new Reimbursement();
        try(Connection conn = ConnectionFactory.getInstance().getConnections())
        {
            String sql = "insert into ERS_REIMBURSEMENT(reimb_amount, reimb_submitted, reimb_description, " +
             "reimb_author, reimb_status_id, reimb_type_id) " +
             "values(?, ?, ?, ?, ?, ?)";
             String[] key = { "reimb_id" };
             conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql, key);
            ps.setDouble(1, reim.getAmount());
            Date today = new Date();
            Timestamp time = new Timestamp(today.getTime());
            ps.setTimestamp(2, time);
            ps.setString(3, reim.getDescription());
            ps.setInt(4, reim.getAuthorId());
            ps.setInt(5, reim.getStatusId());
            ps.setInt(6, reim.getTypeId());
            int row = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                reim.setId(rs.getInt(1));
                reim.setStatus("Pending");
                switch(reim.getTypeId())
                {
                    case 1:    
                        reim.setType("Lodging");
                        break;
                    case 2:
                        reim.setType("Travel");
                        break;
                    case 3:
                        reim.setType("Food");
                        break;
                    case 4:
                        reim.setType("Other");
                        break;
                    default:
                        reim.setType("Other");
                        break;
                }
                reim.setTimeSubmitted(time.toString());
            	conn.commit();
            	return reim;
            }
        } catch(SQLException e) { e.printStackTrace(); }
        results = null;
        return results;
    }

    public Reimbursement updatReimbursement(Reimbursement reim)
    {
        Reimbursement r = reim;
        try(Connection conn = ConnectionFactory.getInstance().getConnections())
        {
            String sql = "{call updateReimbursement(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, reim.getStatusId());
            cs.setInt(2, reim.getResolverId());
            Date today = new Date();
            Timestamp time = new Timestamp(today.getTime());
            cs.setTimestamp(3, time);
            cs.setInt(4, reim.getId());
            cs.execute();
            System.out.println(reim.getId());
            r.setTimeResolved(time.toString());
        } catch(SQLException e) { e.printStackTrace(); }
        return r;
    }
}
