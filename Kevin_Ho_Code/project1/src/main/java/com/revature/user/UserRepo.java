package com.revature.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.util.ConnectionFactory;

public class UserRepo {
	final static Logger log = Logger.getLogger(UserRepo.class);
	public User findUserByUsername(String username){
		User tmp = new User();
		String UN = username.toLowerCase();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			log.debug("Established a connection.");
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM ers_users WHERE LOWER(ers_username) = ?";

			//Create String array holding names of columns that are auto-generated
			String[] keys = {"ers_users_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setString(1, UN);
					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				log.debug("Getting user " + rs.getString("ers_username"));
			
				tmp.setUserId(rs.getInt("ers_users_id"));
				tmp.setFirstName(rs.getString("user_first_name"));
				tmp.setLastName(rs.getString("user_last_name"));
				tmp.setUsername(rs.getString("ers_username"));
				tmp.setPassword(rs.getString("ers_password"));
				tmp.setEmail(rs.getString("user_email"));
				tmp.setRoleId(rs.getInt("user_role_id"));
			}
			
		} catch (SQLException e) {
			log.debug("SQL exception thrown");
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public User addUser( String username, String password, String firstName, String lastName, String email, int roleId){
		if(findUserByUsername(username) == null)
			return null;
		else
		{
			User tmp = new User();
			try(Connection conn = ConnectionFactory.getInstance().getConnection())
			{
				
			} catch (SQLException e) {
				log.debug("Adding User SQL Failed");
				e.printStackTrace();
			}
			
			return tmp;
		}
	}
}
