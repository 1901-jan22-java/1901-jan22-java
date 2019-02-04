package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			String query = "SELECT * FROM Role";
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
	
	//Prepared Statement usage. Better practice than doing it as above. 
	//Efficient for multiple executions and for variables. 
	public Roles getById(int id) {
		Roles r = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM Role WHERE role_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet info = ps.executeQuery();

			if(info.next()) {
				r = new Roles(info.getInt(1), info.getString("Name"));
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	
	//Insert data with prepares statements 
	public Roles save(String title) {
		Roles r = new Roles();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Role(name) VALUES(?)";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"role_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setString(1, title);
			
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				r.setId(pk.getInt(1));
				r.setTitle(title);
				conn.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	public Roles update(Roles r) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE Role SET name = ? WHERE role_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,r.getTitle());
			ps.setInt(2,r.getId());
			
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				conn.commit();
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
}
