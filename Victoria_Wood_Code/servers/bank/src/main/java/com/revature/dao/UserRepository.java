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
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select*from bank_users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				User u = new User(rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5));
				u.setId(rs.getInt(1));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User getByUsername(String username) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select*from bank_users where lower(username) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase()); 
			ResultSet info = ps.executeQuery();
			if (info.next()) {
				u = new User(info.getString("firstname"), info.getString("lastname"),
						username, info.getString("password"));
				u.setId(info.getInt("u_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public User getById(int id) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select*from bank_users where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			if(info.next()) {
				u = new User(info.getString("firstname"), info.getString("lastname"),
						info.getString("username"), info.getString("password"));
				u.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public User addUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String[] keys = {"u_id"}; 
			String sql = "insert into bank_users(firstname, lastname, username, password)"
					+ "values(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, u.getFirstname()); ps.setString(2, u.getLastname());
			ps.setString(3, u.getusername()); ps.setString(4, u.getPassword());
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				u.setId(pk.getInt(1));
				conn.commit();
			} else {
				//something bad happened
				//return user w/o id
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}
