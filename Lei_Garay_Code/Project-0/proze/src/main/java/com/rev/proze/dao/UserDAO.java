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

import com.rev.proze.pojos.User;
import com.rev.proze.util.ConnectionFactory;
import com.rev.proze.util.StringWorks;

import oracle.jdbc.internal.OracleTypes;

public class UserDAO 
{
	static StringWorks sw = new StringWorks();
	
	final static Logger logger = Logger.getLogger(UserDAO.class);
	
	public List<User> findAll()
	{
		List<User> users = new ArrayList<User>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "select * from bank_usr_";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) 
			{
				User temp = new User(	rs.getInt(1), 
										rs.getString(2), 
										rs.getString(3), 
										rs.getString(4),
										rs.getString(5));
				users.add(temp);
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return users;
	}
	
	
	
	public List<User> getListOfUserBy(String property, String string) throws SQLException
	{
		List<User> users = new ArrayList<User>();
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String SQLquery = "select * from bank_usr_ where " + property + " = " + string;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(SQLquery);
			
			while(rs.next()) 
			{
				User temp = new User(	rs.getInt(1), 
										rs.getString(2), 
										rs.getString(3), 
										rs.getString(4),
										rs.getString(5));
				users.add(temp);
			}
			
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return users;
	}
	
	public List<User> getAll()
	{
		List<User> users = new ArrayList<User>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "{call getAllUsers(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) 
			{
				User user = new User	(	rs.getInt(1), 
											rs.getString(2), 
											rs.getString(3), 
											rs.getString(4), 
											rs.getString(5));
				users.add(user);
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		return users;
	}

	public User getById(int id) 
	{
		User user = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query =	"select * from bank_usr_ where bank_usr_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				user = new User(id, query, query, query, query);
				user.setId(rs.getInt(1));
				user.setFn(rs.getString(2));
				user.setLn(rs.getString(3));
				user.setEm(rs.getString(4));
				user.setTp(rs.getString(5));
			}
			else return null;	
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return user;
	}
	
	public User getUserwithMaxID() 
	{
		User user = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query =	"select * from bank_usr_ where bank_usr_id = (select max(bank_usr_id) from bank_usr_)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				user = new User();
				user.setId(rs.getInt	("bank_usr_id"));
				user.setFn(rs.getString	("bank_usr_fn"));
				user.setLn(rs.getString	("bank_usr_ln"));
				user.setEm(rs.getString	("bank_usr_em"));
				user.setTp(rs.getString	("bank_usr_tp"));
			}
			else return null;	
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return user;
	}
	
	public User save(String fn, String ln, String em) {
		User user = new User();
		fn = sw.capString(fn);
		ln = sw.capString(ln);
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String tp = "standard";
			conn.setAutoCommit(false);
			String sql = 
			"insert into bank_usr_ (bank_usr_fn, bank_usr_ln, bank_usr_em, bank_usr_tp) values(?,?,?,?)";
			
			String[] keys = {"bank_usr_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setString(1,fn);
			ps.setString(2,ln);
			ps.setString(3,em);
			ps.setString(4,tp);

			int numRows = ps.executeUpdate();
			
			if(numRows > 0) 
			{
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				user.setId(pk.getInt(1));
				user.setFn(fn);
				user.setLn(ln);
				user.setEm(em);
				user.setTp(tp);
				conn.commit(); 
			}		
		} 
		catch(SQLException e) {e.printStackTrace();}
		return user;
	}
	
	public User updateFull(User user, String newFn, String newLn, String newEm, String newTp) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = 
	        "UPDATE bank_usr_ SET bank_usr_fn = ?, bank_usr_ln = ?, bank_usr_em = , bank_usr_tp = ? WHERE bank_usr_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newFn);
	        ps.setString(2,newLn);
	        ps.setString(3,newEm);
	        ps.setString(4,newTp);
	        ps.setInt(5,user.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + user.getLn() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return user;
	}
	
	public User updateLn(User user, String newLn) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = "UPDATE bank_usr_ SET bank_usr_ln = ? WHERE bank_usr_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newLn);
	        ps.setInt(2,user.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + user.getLn() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return user;
	}
	
	public User updateFn(User user, String newFn) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = "UPDATE bank_usr_ SET bank_usr_fn = ? WHERE bank_usr_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newFn);
	        ps.setInt(2,user.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + user.getLn() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return user;
	}
	
	public User updateEm(User user, String newEm) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = "UPDATE bank_usr_ SET bank_usr_Em = ? WHERE bank_usr_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newEm);
	        ps.setInt(2,user.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + user.getLn() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return user;
	}
	
	public User updateTp(User user, String newTp) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = "UPDATE bank_usr_ SET bank_usr_Tp = ? WHERE bank_usr_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newTp);
	        ps.setInt(2,user.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + user.getLn() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return user;
	}
	
}

