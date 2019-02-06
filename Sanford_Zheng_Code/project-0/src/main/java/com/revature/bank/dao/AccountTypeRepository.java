package com.revature.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.jdbc.util.ConnectionFactory;

public class AccountTypeRepository {

	private static final Logger logger = Logger.getLogger(AccountRepository.class);
	private static final HashMap<Integer, String> ACCOUNT_TYPES = new HashMap<>();
	
	static {
		loadAccountTypes();
	}
	
	public static void loadAccountTypes() {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from bank_account_types";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				ACCOUNT_TYPES.put(rs.getInt("account_type_id"), rs.getString("account_type"));
			}
		} catch( SQLException e ) {
			logger.error("SQLException occurred when loading account types!", e);;
		}
	}

	public static void addAccountType(String type_name) {
		if(ACCOUNT_TYPES.containsValue(type_name)) return;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "{call add_bank_account_types(?);}";
			
			CallableStatement cs = conn.prepareCall(query);
			cs.setString(1, type_name);
			cs.execute();
		} catch( SQLException e ) {
			logger.error("SQLException occurred when adding account type: " + type_name, e);
		}
		loadAccountTypes();
	}
	
	public static String getAccountTypeByID(int atid) {
		String at = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from bank_account_types where account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, atid);
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				at = rs.getString("account_type");
			}
		} catch( SQLException e ) {
			logger.error("SQLException occurred when loading account types!", e);
		}
		
		return at;
	}
	
	// Return deep copy of account types
	public static HashMap<Integer, String> getTypes(){
		loadAccountTypes();
		HashMap<Integer, String> res = new HashMap<>();
		
		for(Integer key: ACCOUNT_TYPES.keySet())
			res.put(key.intValue(), ACCOUNT_TYPES.get(key));
		
		return res;
	}
	
}
