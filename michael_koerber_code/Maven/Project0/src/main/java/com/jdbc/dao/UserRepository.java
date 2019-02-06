package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.pojos.User;
import com.jdbc.util.ConnectionFactory;

public class UserRepository {
	
	// Method used for logging in with username and password, executed in the User View
	public static User findLoginInfo(String username, String password){
		User user = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from bankusers where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setPassword(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static User save(User obj){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "insert into bankusers(fName, lName, username, password) values(?, ?, ?, ?)";
			String[] keys = {"userId"};
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3,  obj.getUsername());
			ps.setString(4, obj.getPassword());	
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				obj.setUserId(pk.getInt(1));
			}
		} catch (SQLException e) {
			
		}
		return obj;
	}
	
	public static List<User> findAll() {
		List<User> allUsers = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from bankusers";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);

			while (rs.next()) {
				User user = new User();

				user.setUserId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setPassword(rs.getString(5));
				allUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

}
