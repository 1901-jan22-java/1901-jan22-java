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

	private static final Logger logger = Logger.getLogger(AccountRepository.class);

	/* JDBC Queries */
    public static User getByID(Integer id) throws NoSuchBankUserException {
		User user = null;
    	try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
    		String sql = "select * from bank_users where id = ?";

    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.getFetchSize() == 0)
				throw new NoSuchBankUserException();
			else
				user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"));
		} catch( SQLException e ) {
			logger.error("SQLException occurred in getByID(" + id +")!", e);
		}
    	return user;
	}

	public static User getByUsername(String username) throws NoSuchBankUserException {
		User user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_users where username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if(rs.getFetchSize() == 0)
			    throw new NoSuchBankUserException();
			else
			    user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"));
		} catch( SQLException e ) {
			logger.error("SQLException occurred in getByUsername(" + username +")!", e);
		}
		return user;
	}

	public static User createUser(String username, String password) throws UnableToGenerateKeyException{
		User user = new User(username, password);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "insert into bank_users(username, password) values(?, ?)";

			String[] keys = {"user_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, username);
			ps.setString(2, password);

			int updates = ps.executeUpdate();

			if(updates > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"));
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
