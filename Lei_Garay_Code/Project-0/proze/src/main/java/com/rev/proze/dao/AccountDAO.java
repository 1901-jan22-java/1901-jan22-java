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

import com.rev.proze.pojos.Account;
import com.rev.proze.pojos.User;
import com.rev.proze.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class AccountDAO 
{

	final static Logger logger = Logger.getLogger(UserDAO.class);
	
	public List<Account> 	findAll()
	{
		List<Account> 	accounts 	= new ArrayList<Account>();
		try(Connection 	conn 		= ConnectionFactory.getInstance().getConnection())
		{
			String 		qr = "select * from bank_acc_";
			Statement 	st = conn.createStatement();
			ResultSet 	rs = st.executeQuery(qr);
			while(rs.next()) 
			{
				Account temp = new Account(	rs.getInt("bank_acc_id"), 
											rs.getInt("bank_usr_id"),
											rs.getString("bank_acc_tp"), 
											rs.getDouble("bank_acc_bl"));
				accounts.add(temp);
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		return accounts;
	}
	
	public List<Account> 	findAll(User user)
	{
		List<Account> 	accounts 	= new ArrayList<Account>();
		try(Connection 	conn 		= ConnectionFactory.getInstance().getConnection())
		{
			String 		qr = "select * from bank_acc_ where bank_usr_id = " + user.getId() ;
			Statement 	st = conn.createStatement();
			ResultSet 	rs = st.executeQuery(qr);
			while(rs.next()) 
			{
				Account temp = new Account(	rs.getInt	("bank_acc_id"), 
											rs.getInt	("bank_usr_id"),
											rs.getString("bank_acc_tp"), 
											rs.getDouble("bank_acc_bl"));
				accounts.add(temp);
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		return accounts;
	}
	
	public List<Account> 	getAll()
	{
		List<Account> accounts 	= new ArrayList<Account>();
		try(Connection conn 	= ConnectionFactory.getInstance().getConnection())
		{
			String 				qr = "{call getAllAccounts(?)}";
			CallableStatement 	cs = conn.prepareCall(qr);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet 			rs = (ResultSet) cs.getObject(1);
			while(rs.next()) 
			{	
				Account account 	= new Account(	rs.getInt(1), 
													rs.getInt(2), 
													rs.getString(3), 
													rs.getDouble(4));
				accounts.add(account);
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		return accounts;
	}
	
	public List<Account> 	getAccountsByUserId(int id)
	{
		List<Account> 	accounts = new ArrayList<Account>();
		try(Connection 	conn 	= ConnectionFactory.getInstance().getConnection())
		{
			String qr = "select * from bank_usr_ where bank_usr_id = ?";
			PreparedStatement ps = conn.prepareStatement(qr);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(qr);
			while(rs.next()) 
			{
				Account temp = new Account(	rs.getInt("bank_acc_id"),
											rs.getInt("bank_usr_id"),
											rs.getString("bank_acc_tp"), 
											rs.getDouble("bank_acc_bl"));
				accounts.add(temp);}
		} 
		catch(SQLException e) {e.printStackTrace();}
		return accounts;
	}
	
	public List<Account> 	getListOfAccountsById(User user) throws SQLException
	{
		List<Account> accounts = new ArrayList<Account>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String 		qr = "select * from bank_acc_ where bank_usr_id = " + String.valueOf(user.getId());
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(qr);
			
			while(rs.next()) 
			{
				Account temp = new Account(	rs.getInt(1), 
											rs.getInt(2), 
											rs.getString(3), 
											rs.getDouble(4));
				accounts.add(temp);
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		return accounts;
	}
	
	public Account getById(int id) 
	{
		Account account = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query =	"select * from bank_acc_ where bank_acc_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				account = new Account(id, null, query,null);
				account.setId(rs.getInt(1));
				account.setUsr_id(rs.getInt(2));
				account.setTp(rs.getString(3));
				account.setBl(rs.getDouble(4));
			}
			else return null;	
		} 
		catch(SQLException e) {e.printStackTrace();}
		return account;
	}

	public Integer getAccountCount(User user) 
	{
		int count = 0;
		Account account = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query =	"select count(bank_usr_id) as total from bank_acc_ where bank_usr_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				count = rs.getInt("total");
			}
			else return null;	
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return count;
	}
	
	public Account insert(Integer user_id, String tp, Double bl) 
	{
		Account account = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = 
			"insert into bank_acc_ (bank_usr_id, bank_acc_tp, bank_acc_bl) values(?,?,?)";
			
			String[] keys = {"bank_acc_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setInt(1, user_id);
			ps.setString(2,tp);
			ps.setDouble(3,bl);

			int numRows = ps.executeUpdate();
			
			if(numRows > 0) 
			{
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				account.setId(pk.getInt(1));
				account.setUsr_id(user_id);
				account.setTp(tp);
				account.setBl(bl);
				conn.commit(); 
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		return account;
	}
	
	public Account clean(Account account) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = 
	        "UPDATE bank_acc_ SET bank_acc_bl = 0 WHERE bank_acc_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setInt(1,account.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + account.getId() + " CLEANED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER CLEANED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return account;
	}
	
	public Account deposit(Account account, Double amount) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = 
	        "UPDATE bank_acc_ SET bank_acc_bl = banl_acc_bl + ? WHERE bank_acc_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setDouble(1,amount);
	        ps.setInt(2,account.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("ACCOUNT " + account.getId() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO ACCOUNT UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return account;
	}
	
	public Account withdraw(Account account, Double amount) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = 
	        "UPDATE bank_acc_ SET bank_acc_bl = banl_acc_bl - ? WHERE bank_acc_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setDouble(1,amount);
	        ps.setInt(2,account.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + account.getId() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return account;
	}
	
	public Account changeBalanceTo(Account account, Double newBl) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = "UPDATE bank_acc_ SET bank_acc_bl = ? WHERE bank_acc_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setDouble(1,newBl);
	        ps.setInt(2,account.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + account.getId() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return account;
	}
	
	public Account updateType(Account account, String newTp) 
	{ 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
	        String sql = "UPDATE bank_acc_ SET bank_acc_tp = ? WHERE bank_acc_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	            
	        ps.setString(1,newTp);
	        ps.setInt(2,account.getId());
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("USER " + account.getTp() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO USER UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return account;
	}
	
	public Account getAccountwithMaxID(User user) 
	{
		Account account = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query =	"select * from bank_acc_ where bank_acc_id = (select max(bank_acc_id) from bank_acc_) and bank_usr_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				account = new Account();
				account.setId(rs.getInt		("bank_usr_id"));
				account.setId(rs.getInt		("bank_usr_id"));
				account.setTp(rs.getString	("bank_acc_tp"));
				account.setBl(rs.getDouble	("bank_acc_bl"));
			}
			else return null;	
		} 
		catch(SQLException e) {e.printStackTrace();}
		return account;
	}
	
}

