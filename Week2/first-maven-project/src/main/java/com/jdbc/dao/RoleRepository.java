package com.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.pojos.Role;
import com.jdbc.util.ConnectionFactory;

public class RoleRepository {
	
	
	/*
	 * STATEMENT 
	 * - takes an SQL statement in as a string, 
	 *   executes it, and returns the result
	 * - allows SQL injection (not precompiled 
	 *   before executing on db) so it is bad 
	 *   to use. If you must, use it for queries
	 *   which do not take parameters like a
	 *   find all method
	 */
	public List<Role> findAll(){
		List<Role> roles = new ArrayList<Role>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			
			String query = "select * from roles";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				//can access data in cells via column index OR name
				Role temp = new 
						Role(rs.getInt(1), rs.getString("Title"));
				roles.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return roles;
	}
}

