package com.revature.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class UserRepo {
	
	public User findUserByUsername(String username){
		User tmp = new User();
		String UN = username.toLowerCase();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM ers_users WHERE LOWER(ers_username) = ?";

			//Create String array holding names of columns that are auto-generated
			String[] keys = {"ers_users_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setString(1, UN);
					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tmp.setUserId(rs.getInt("ers_users_id"));
				tmp.setUsername(rs.getString("ers_username"));
				tmp.setPassword(rs.getString("ers_password"));
				tmp.setFirstName(rs.getString("user_first_name"));
				tmp.setLastName(rs.getString("user_last_name"));
				tmp.setEmail(rs.getString("user_email"));
				tmp.setRoleId(rs.getInt("user_role_id"));
			}
			return tmp;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findUserByEmail(String email){
		User tmp = new User();
		String Email = email.toLowerCase();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM ers_users WHERE LOWER(user_email) = ?";

			//Create String array holding names of columns that are auto-generated
			String[] keys = {"ers_users_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setString(1, Email);
					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tmp.setUserId(rs.getInt("ers_users_id"));
				tmp.setUsername(rs.getString("ers_username"));
				tmp.setPassword(rs.getString("ers_password"));
				tmp.setFirstName(rs.getString("user_first_name"));
				tmp.setLastName(rs.getString("user_last_name"));
				tmp.setEmail(rs.getString("user_email"));
				tmp.setRoleId(rs.getInt("user_role_id"));
			}
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public User addUser( String username, String password, String firstName, 
			String lastName, String email, int roleId){
		User tmp = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ers_users(ers_username, ers_password, user_first_name, "
						+ "user_last_name, user_email, user_role_id) "
						+ "values (?,?,?,?,?,?)";
			String[] keys = {"ers_users_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setInt(6, roleId);					
						
			int numRows = ps.executeUpdate();
			conn.commit();
					
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				tmp.setUserId((pk.getInt(1)));
				tmp.setUsername(username);
				tmp.setPassword(password);
				tmp.setFirstName(firstName);
				tmp.setLastName(lastName);
				tmp.setEmail(email);
				tmp.setRoleId(roleId);
			}
			return tmp;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}