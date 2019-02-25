package com.revature.dao;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;



public class UserRepository
{
    public UserRepository(){ }
    public User logInUser(String username, String password)
    {
        User temp = new User();
        try(Connection conn = ConnectionFactory.getInstance().getConnections())
        {
            String query = "select * from ERS_USERS where ers_username = ? and ers_password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs  = ps.executeQuery();
            if(rs.next())
            {
                temp.setId(rs.getInt(1));
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setFirstName(rs.getString(4));
                temp.setLastName(rs.getString(5));
                temp.setEmail(rs.getString(6));
                temp.setRoleId(rs.getInt(7));
                return temp;
            }
        } catch (SQLException e) {
			e.printStackTrace();
        }
        temp = null;
        return temp;
    }
    public User getReimbursements(User user)
    {
        User u = user;
        try(Connection conn = ConnectionFactory.getInstance().getConnections())
        {
            String sql = "select * from ERS_REIMBURSEMENT where reimb_author = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Reimbursement reim = new Reimbursement();
                reim.setId(rs.getInt(1));
                reim.setAmount(rs.getDouble(2));
                reim.setTimeSubmitted(rs.getTimestamp(3).toString());
                reim.setDescription(rs.getString(5));
                reim.setAuthorId(rs.getInt(6));                
                reim.setStatusId(rs.getInt(8));
                reim.setTypeId(rs.getInt(9));                
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
                switch(reim.getStatusId())
                {
                    case 1:
                        reim.setStatus("Pending");
                        break;
                    case 2:
                        reim.setStatus("Approved");
                        reim.setTimeResolved(rs.getTimestamp(4).toString());
                        reim.setResolverId(rs.getInt(7));
                        break;
                    case 3:
                        reim.setStatus("Denied");
                        reim.setTimeResolved(rs.getTimestamp(4).toString());
                        reim.setResolverId(rs.getInt(7));
                        break;
                    default:
                        reim.setStatus("Pending");
                        break;
                }
                u.addReimbursement(reim);
            }
        } catch(SQLException e) { e.printStackTrace();}
        return u;
    }
    public User getAllReimbursements(User user)
    {
        User u = user;
        try(Connection conn = ConnectionFactory.getInstance().getConnections())
        {
            String sql = "select * from ERS_REIMBURSEMENT";
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next())
            {
                Reimbursement reim = new Reimbursement();
                reim.setId(rs.getInt(1));
                reim.setAmount(rs.getDouble(2));
                reim.setTimeSubmitted(rs.getTimestamp(3).toString());
                reim.setDescription(rs.getString(5));
                reim.setAuthorId(rs.getInt(6));
                reim.setStatusId(rs.getInt(8));
                reim.setTypeId(rs.getInt(9));
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
                switch(reim.getStatusId())
                {
                    case 1:
                        reim.setStatus("Pending");
                        break;
                    case 2:
                        reim.setStatus("Approved");
                        reim.setTimeResolved(rs.getTimestamp(4).toString());
                        reim.setResolverId(rs.getInt(7));
                        break;
                    case 3:
                        reim.setStatus("Denied");
                        reim.setTimeResolved(rs.getTimestamp(4).toString());
                        reim.setResolverId(rs.getInt(7));
                        break;
                    default:
                        reim.setStatus("Pending");
                        break;
                }
                u.addReimbursement(reim);
            }
        } catch(SQLException e) { e.printStackTrace();}
        return u;
    }
}
