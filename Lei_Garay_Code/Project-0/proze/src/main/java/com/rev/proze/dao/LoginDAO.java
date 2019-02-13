package com.rev.proze.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rev.proze.pojos.Login;
import com.rev.proze.pojos.User;
import com.rev.proze.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class LoginDAO 
{
	final static Logger logger = Logger.getLogger(UserDAO.class);
	
	public List<Login> findAll()
	{
		List<Login> logins = new ArrayList<Login>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String query = "select * from bank_lgn_";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) 
			{
				Login temp = new Login(	rs.getString("bank_lgn_un"), 
										rs.getString("bank_lgn_pw"), 
										rs.getInt	("bank_lgn_id"));
				logins.add(temp);
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		return logins;
	}

	public List<Login> getAll()
	{
		List<Login> logins = new ArrayList<Login>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "{call getAllLogins(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) 
			{
				Login login = new Login(	rs.getString(1), 
											rs.getString(2), 
											rs.getInt(3)); 
				logins.add(login);
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		return logins;
	}

	public Login getById(int id) 
	{
		Login login = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query =	"select * from bank_lgn_ where bank_lgn_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				login = new Login(query, query, id);
				login.setUn(rs.getString(1));
				login.setPw(rs.getString(2));
				login.setId(rs.getInt(3));
			}
			else return null;	
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return login;
	}
	
	public Login getByUsername(String un) 
	{
		Login login = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query =	"select * from bank_lgn_ where bank_lgn_un = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				login = new Login(query, query, null);
				login.setUn(rs.getString(1));
				login.setPw(rs.getString(2));
				login.setId(rs.getInt(3));
			}
			else return null;	
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return login;
	}
	
	public Login save(String un, String pw, Integer id) {
		Login login = null;
		String sp = ", ";
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = 
			"insert into bank_lgn_ (bank_lgn_un, bank_lgn_pw, bank_lgn_id) values(?,?,?)";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,un);
			ps.setString(2,pw);
			ps.setInt(3,id);

			int numRows = ps.executeUpdate();
			
			if(numRows > 0) 
			{
				try
				{
					login.setUn(un);
					login.setPw(pw);
					login.setId(id);
				}
				catch(NullPointerException e) {}
				conn.commit(); 
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return login;
	}
	
	public Login updateFull(Login login, String newUn, String newPw) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = 
	        "UPDATE bank_lgn_ SET bank_lgn_un = ?, bank_lgn_pw = ? WHERE bank_lgn_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newUn);
	        ps.setString(2,newPw);
	        ps.setInt(3,login.getId());
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + login.getId() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return login;
	}
	
	public Login updatePw(Login login, String newPw) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = 
	        "UPDATE bank_lgn_ SET bank_lgn_pw = ? WHERE bank_lgn_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newPw);
	        ps.setInt(2,login.getId());
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("PASSWORD " + login.getId() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO PASSWORD UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return login;
	}
	
	public Login updateUn(Login login, String newUn) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = 
	        "UPDATE bank_lgn_ SET bank_lgn_un = ? WHERE bank_lgn_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newUn);
	        ps.setInt(2,login.getId());
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USERNAME " + login.getId() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USERNAME UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return login;
	}
	
	public Login getLoginwithMaxID() 
	{
		Login login = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query =	"select * from bank_lgn_ where bank_lgn_id = (select max(bank_lgn_id) from bank_lgn_)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				login = new Login();
				login.setUn(rs.getString	("bank_lgn_un"));
				login.setPw(rs.getString	("bank_lgn_pw"));
				login.setId(rs.getInt		("bank_lgn_id"));
			}
			else return null;	
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return login;
	}

	public Login updateEm(Login login, String newEm) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = 
	        "UPDATE bank_lgn_ SET bank_lgn_em = ? WHERE bank_lgn_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newEm);
	        ps.setInt(2,login.getId());
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("EMAIL " + login.getId() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO EMAIL UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return login;
	}

	public User exists(String un, String pw)
	{
		List<Login> all = new LoginDAO().findAll();
		User user = null;
		
		for (Login login : all) 
		{
			if(login.getUn().equals(un) && login.getPw().equals(pw))
			{
				user = new UserDAO().getById(login.getId());
			
			}
		}
		return user;
	}
}


