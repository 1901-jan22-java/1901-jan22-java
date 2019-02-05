package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.jdbc.util.ConnectionFactory;
import com.revature.bank.pojos.User;

public class UserRepository {

	private static final Logger logger = Logger.getLogger(AccountRepository.class);

	private static Connection conn;
	
	static {
		try {
			conn = ConnectionFactory.getInstance().getConnection();
		} catch (SQLException e) {
			logger.error("Exception:\n", e);
		}
	}
	
	public static User getByUser(String username) {
		User user = null;
		try {
			String query = "select * from bank_users where username = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
				user = new User(rs.getString("username"), rs.getString("password"));
		} catch( SQLException e ) {
			e.printStackTrace();
		} 
		
		return user;
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			logger.error("Exception Occured!", e);
		}
	}
}
