package com.revature.bank.dao;

import com.jdbc.util.ConnectionFactory;
import com.revature.bank.pojos.Account;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AccountRepository {

	// Probably never used for types...
	private static final HashMap<Integer, String> types = AccountTypeRepoWithList.getTypes();

	private static final Logger logger = Logger.getLogger(AccountRepository.class);
	
	public static Account getAccountsByID(Integer id) {
		Account acc = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from bank_accounts where user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				acc = new Account( rs.getInt("account_id"), null,
						rs.getInt("account_type_id"), rs.getDouble("balance") );
			}
		} catch( SQLException e ) {
			logger.error("SQLException in getAccountsByID("+id+")!", e);
		} 
		
		return acc;
	}

	
}
