package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.jdbc.util.ConnectionFactory;
import com.revature.bank.pojos.Account;

public class AccountRepository {

	private static final Logger logger = Logger.getLogger(AccountRepository.class);
	private static final HashMap<Integer, String> ACCOUNT_TYPE = new HashMap<>();

	private static Connection conn;
	
	static {
		try {
			conn = ConnectionFactory.getInstance().getConnection();
		} catch (SQLException e) {
			logger.error("Exception: ", e);
		}
	}
		
	public static Account getAccounts(String username) {
		Account acc = null;
		try {
			
			String query = "select * from bank_accounts where username = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				acc = new Account(
						ACCOUNT_TYPE.get(rs.getInt("account_type_id")),
						rs.getDouble("balance")
						);
			}
		} catch( SQLException e ) {
			e.printStackTrace();
		} 
		
		return acc;
	}
	
	public HashMap<Integer, String> getTypes(){
		HashMap<Integer, String> res = new HashMap<>();
		
		for(Integer key: ACCOUNT_TYPE.keySet())
			res.put(key.intValue(), ACCOUNT_TYPE.get(key));
		
		return res;
	}
	
}
