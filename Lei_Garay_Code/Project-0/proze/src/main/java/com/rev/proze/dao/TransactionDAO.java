package com.rev.proze.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rev.proze.pojos.Account;
import com.rev.proze.pojos.Transaction;
import com.rev.proze.util.ConnectionFactory;

import oracle.sql.DATE;

public class TransactionDAO 
{

	final static Logger logger = Logger.getLogger(UserDAO.class);
	
	public List<Transaction> findAll()
	{
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			
			String query = "select * from bank_trx_";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) 
			{
				Transaction temp = new Transaction(	rs.getInt(1), 
										rs.getInt("bank_trx_acc_id"), 
										rs.getString("bank_trx_tp"),
										rs.getTimestamp("banl_trx_ts"),
										rs.getDouble("bank_trx_am"));
				transactions.add(temp);
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return transactions;
	}
	
	public Transaction getById(int id) 
	{
		Transaction transaction = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query =	"select * from bank_trx_ where bank_trx_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
			{
				transaction = new Transaction(id,null,query,null,null);
				transaction.setId(rs.getInt(1));
				transaction.setAcc_id(rs.getInt(2));
				transaction.setType(rs.getString(3));
				transaction.setTimeStamp(rs.getDate(4));
				transaction.setAmt(rs.getDouble(5));
			}
			else return null;	
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return transaction;
	}
	
	public Transaction save(Integer acc_id, String trx_type, Double trx_am) 
	{
		Transaction transaction = null;
		String sp = ", ";
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = 
			"insert into bank_trx_ (bank_trx_acc_id, bank_trx_tp, bank_trx_am) values(?,?,?)";
			
			String[] keys = {"bank_trx_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setInt(1, acc_id);
			ps.setString(2,trx_type);
			ps.setDouble(3, trx_am);

			int numRows = ps.executeUpdate();
			
			if(numRows > 0) 
			{
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				transaction.setId(pk.getInt(1));
				transaction.setAcc_id(pk.getInt(2));
				transaction.setType(pk.getString(3));
				transaction.setTimeStamp(pk.getTimestamp(4));
				transaction.setAmt(pk.getDouble(5));
				conn.commit(); 
			}
		} 
		catch(SQLException e) {e.printStackTrace();}
		
		return transaction;
	}
	
	public Transaction update(Account account, Double amount) 
	{ 
		Transaction transaction = new Transaction();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
			String type = "";
			if(amount > 0) {type="deposit";} 
			else if(amount < 0) {type="withdrawal";}
			
	        String sql = 
	        "UPDATE bank_trx_ SET bank_trx_acc_id = ?, bank_trx_tp = ?, "+
	        	                 "bank_trx_am = ? WHERE bank_trx_id = ?";
	            
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, account.getId()); 
	        ps.setString(2,type);
	        ps.setDouble(3,amount);
	            
	        int numRows = ps.executeUpdate();
	            
	        if(numRows > 0) 
	        {
	         	logger.info("TRANSACTION " + transaction.getId() + " UPDATED");
	            conn.commit();
	        } 
	        else {	logger.info("NO TRANSACTION UPDATED");	return null;	}
	    } 
		catch(SQLException e) {e.printStackTrace();}    
	    return transaction;
	}
}


