package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.jdbc.util.ConnectionFactory;
import com.revature.users.User;

public class UserRepository {
	final static Logger log = Logger.getLogger(UserRepository.class);
	
	public User findUser(String username) {
		username = username.toUpperCase();
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM Users WHERE UPPER(username) = ?";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"user_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setString(1, username);
					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				log.debug(rs.getString("firstname"));
				user.setUserId(rs.getInt("user_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getInt("password"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getInt("user_role_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User newUser(String firstname,  String lastname, String username, int password, String email, int role) {
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Users(firstname, lastname, username, password, email, user_role_id) VALUES(?,?,?,?,?,?)";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"user_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setInt(4, password);
			ps.setString(5, email);
			ps.setInt(6, role);
			
			
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				user.setUserId(pk.getInt(1));
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setRole(role);
				conn.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
