package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.ConnectionFactory;
import com.revature.pojos.User;

public class UserRepository {
	public User findUserByUN(String username) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Bank_Users WHERE UPPER(username) = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username.toUpperCase());

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setUserId(rs.getInt("user_id"));
				user.setPassword(rs.getString("pass"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Bank_Users";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User temp = new User();
				temp.setFirstname(rs.getString("firstname"));
				temp.setLastname(rs.getString("lastname"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("pass"));
				temp.setUserId(rs.getInt("user_id"));
				users.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return users;
		
	}
	
	
	public User findByID(int id) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Bank_Users WHERE user_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setUserId(rs.getInt("user_id"));
				user.setPassword(rs.getString("pass"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User newUser(User user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Bank_Users(firstname, lastname, username, pass) VALUES(?,?,?,?)";
			String[] keys = {"user_id"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			
			
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());

			int numRows= ps.executeUpdate();

			if(numRows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				user.setUserId(rs.getInt(1));
				conn.commit();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
