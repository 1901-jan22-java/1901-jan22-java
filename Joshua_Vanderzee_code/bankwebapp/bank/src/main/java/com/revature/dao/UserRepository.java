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
	
	public List<User> getALL() {
		List<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_users";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				User u = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				u.setId(rs.getInt(1));
				users.add(u);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User getById(int id) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_users where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public User getByUsername(String username) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public User saveUser(String username, String password, String firstname, String lastname) {
		User u = new User(firstname, lastname, username, password);;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into bank_users(firstname, lastname, username, password) values(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstname());
			ps.setString(1, u.getLastname());
			ps.setString(1, u.getUsername());
			ps.setString(1, u.getPassword());
			int rows = ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			if (pk.next()) {
				u.setId(pk.getInt(1));
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
