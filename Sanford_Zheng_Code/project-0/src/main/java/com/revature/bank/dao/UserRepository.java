package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.jdbc.util.ConnectionFactory;
import com.revature.bank.pojos.User;

public interface UserRepository {

	Logger logger = Logger.getLogger(AccountRepository.class);
	
	public static User getByUsername(String username) {
		User user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from bank_users where username = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
				user = new User(rs.getString("username"), rs.getString("password"));
		} catch( SQLException e ) {
			logger.error("SQLException occured in UserRepository.getByUser()!", e);
		} 
		
		return user;
	}
	
	public static User saveUser(User u) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "";
		} catch( SQLException e) {
			logger.error("SQLException occured in UserRepository!", e);
		}
		
		return null;
	}
	
}
