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
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			//STATEMENT
			String sql = "select * from bank_users";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				User u = new User(
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("username"),
						rs.getString("password"));
				u.setId(rs.getInt(1));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User getById(int id) {
		User u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			
			String sql = "select * from bank_users where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set values to ? params, index starts at 1
			ps.setInt(1, id); 
			
			//get results from query, only set u = NN if u exists
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u = new User(
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("username"),
						rs.getString("password"));
				u.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public User getByUsername(String username) {
		User u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			
			String sql = "select * from bank_users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set values to ? params, index starts at 1
			ps.setString(1, username); 
			
			//get results from query, only set u = NN if u exists
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u = new User(
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("username"),
						rs.getString("password"));
				u.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

}
