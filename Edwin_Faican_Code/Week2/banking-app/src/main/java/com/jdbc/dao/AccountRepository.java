package com.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.account.Account;
import com.revature.app.App;
import com.jdbc.util.ConnectionFactory;

public class AccountRepository {
	final static Logger logger = Logger.getLogger(AccountRepository.class);
	
	//Since this query is literal, a Statement can be used to retrieve all account types. 
	public List<String> accountTypes() {
		List<String> types = new ArrayList<String>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM Type ORDER BY type_id";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String temp = rs.getString("type_name");
				types.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return types;
	}
	
	//Prepared Statement used to retrieve all account of a particular client
	public List<Account> findAccounts(int client) {
		List<Account> accounts = new ArrayList<Account>();
		List<String> types = accountTypes();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Account WHERE client_id = ?";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"account_number"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setInt(1, client);
			ResultSet pk = ps.executeQuery();

			while(pk.next()) {
				Account temp = new Account(pk.getInt("account_number"), types.get(pk.getInt("account_type")-1), pk.getDouble("balance"));
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	//Insert data with prepared statement 
	public Account openAccount(int type, int client, double amount) {
		Account acc = new Account();
		List<String> types = accountTypes();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Account(account_type, client_id, balance) VALUES(?,?,?)";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"account_number"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setInt(1, type);
			ps.setInt(2, client);
			ps.setDouble(3, amount);
			
			
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				acc.setAcctNumber(pk.getInt(1));
				acc.setType(types.get(type - 1));
				acc.setBalance(amount);
				conn.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	
	
	//Implemented with Prepared Statement for now. 
	 
//	public Account updateBalance(Account acc) {
//		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			conn.setAutoCommit(false);
//			String sql = "UPDATE Account SET balance = ? WHERE account_number = ?";
//			//Create String array holding names of columns that are auto-generated
//			String[] keys = {"account_number"};
//			PreparedStatement ps = conn.prepareStatement(sql,keys);
//			
//			ps.setDouble(1, acc.getBalance());
//			ps.setInt(2, acc.getAcctNumber());
//						
//			int numRows = ps.executeUpdate();
//			
//			if(numRows > 0) {
//				conn.commit();
//			} else {
//				return null;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return acc;
//	}
	
	//Update data with Call Statement: 
	//Will normally be used to update balance from accounts as Clients do not have permission to change any other value.
	public Account updateBalance(Account acc){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call updateBalance(?,?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setDouble(1, acc.getBalance());
			cs.setInt(2, acc.getAcctNumber());
			
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	
	//Deletion of account with Prepared Statement
	public Account closeAccount(Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "DELETE FROM Account WHERE account_number = ?";
			//Create String array holding names of columns that are auto-generated
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, acc.getAcctNumber());
						
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				conn.commit();
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return acc;
	}
}
