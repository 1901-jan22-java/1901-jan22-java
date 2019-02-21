package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class UserRepository {
	
	public List<User> getAll(){
		
		List<User> users = new ArrayList<User>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM bank_users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				User u = new User(
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5));
				u.setId(rs.getInt(1));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	public User getById(int id){
		
		User user = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "Select * FROM bank_users WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User(
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
				);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getByUsername(String username) {
		User user = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		String sql = "Select * FROM bank_users WHERE lower(username) = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username.toLowerCase());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new User(
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5)
			);
		}
	  } catch (SQLException e) {
		e.printStackTrace();
	}
		return user;
	}
	
	public User addUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO bank_users (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";
			
			String[] key = {"u_id"};
			PreparedStatement ps = conn.prepareStatement(sql, key);
			
			ps.setString(1,  u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4,  u.getPassword());
			
			int numRowsUpdated = ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			if(pk.next()) {
				u.setId(pk.getInt(1));
				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
