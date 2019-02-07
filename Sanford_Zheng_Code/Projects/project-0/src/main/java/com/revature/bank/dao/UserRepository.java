package com.revature.bank.dao;

import com.jdbc.util.ConnectionFactory;
import com.revature.bank.exceptions.NoSuchBankUserException;
import com.revature.bank.exceptions.UnableToGenerateKeyException;
import com.revature.bank.pojos.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

	private static final Logger logger = Logger.getLogger(UserRepository.class);

	/* JDBC Queries */
    public static User getUser(Integer id) throws NoSuchBankUserException {
		User user = null;
    	try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
    		String sql = "select * from bank_users where user_id = ?";

    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.getFetchSize() == 0)
				throw new NoSuchBankUserException();
			
			user = new User(rs.getInt("user_id"), rs.getString("account_username"), rs.getString("account_password"));
			conn.commit();
		} catch( SQLException e ) {
			logger.error("SQLException occurred in getByID(" + id +")!", e);
		}
    	return user;
	}

	public static User getUser(String username) throws NoSuchBankUserException {
		User user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_users where account_username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if(rs.getFetchSize() == 0)
			    throw new NoSuchBankUserException();
			
		    user = new User(rs.getInt("user_id"), rs.getString("account_username"), rs.getString("account_password"));
			
		} catch( SQLException e ) {
			logger.error("SQLException occurred in getByUsername(" + username +")!", e);
		}
		return user;
	}

	public static User createUser(String username, String password) throws UnableToGenerateKeyException{
		User user = new User(username, password);
		try {
		if( getUser(username) != null ) {
			System.out.println("Please enter a unique identifier");
			return user;
		}
		}catch(NoSuchBankUserException e) {
			// nothing here we want this
		}
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "insert into bank_users(account_username, account_password) values(?, ?)";

			String[] keys = {"user_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, username);
			ps.setString(2, password);

			int updates = ps.executeUpdate();

			if(updates > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				user = new User(rs.getInt("user_id"), rs.getString("account_username"), rs.getString("account_password"));
			
				conn.commit();
			} else {
				throw new UnableToGenerateKeyException();
			}
		} catch( SQLException e ) {
			logger.error("SQLException occurred in getByUsername(" + username +")!", e);
		}
		return user;
    }

	public static User createUser(User u) throws UnableToGenerateKeyException{
		return createUser(u.getUsername(), u.getPassword());
	}
	
}
