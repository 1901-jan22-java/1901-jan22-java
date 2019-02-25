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
			String sql = "select * from bank_user";
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
			
			String sql = "select * from bank_user where u_id = ?";
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
			
			String sql = "select * from bank_user where "
					+ "lower(username) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set values to ? params, index starts at 1
			ps.setString(1, username.toLowerCase()); 
			
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
	
	public User addUser(User u) {
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			
			//optionally set autocommit to false until checking
			conn.setAutoCommit(false);
			
			String sql = "insert into bank_user (firstname, lastname, "
					+ "username, password) values (?,?, ?, ?)";
			
			String[] key = {"u_id"};
			PreparedStatement ps = conn.prepareStatement(sql, key);
			
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			
			int numRowsUpdated = ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			if(pk.next()) {
				u.setId(pk.getInt(1));
				conn.commit();
			}
			else {
				//something bad happened
				//return user without id 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}