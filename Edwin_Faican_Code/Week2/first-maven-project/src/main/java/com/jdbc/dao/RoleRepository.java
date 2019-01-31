package com.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.pojos.Roles;
import com.jdbc.util.ConnectionFactory;


public class RoleRepository {
	//Takes an SQL statement as a string, executes it and returns the result. 
	//This is a Statement and is bad practice. 
	public List<Roles> findAll() {
		List<Roles> roles = new ArrayList<Roles>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM Role WHERE role_id = 1";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Roles temp = new Roles(rs.getInt(1), rs.getString("Name"));
				roles.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return roles;
	}
}
