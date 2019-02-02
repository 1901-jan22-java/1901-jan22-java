package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.pojos.Role;
import com.jdbc.util.ConnectionFactory;

public class RoleRepository {

	/*
	 * Statement
	 * - takes an SQL statement in as a string,
	 * executes it, and returns the result
	 * - allows SQL injection so it is bad to use.
	 * If you must, use it for queries which do not take parameters like a find all method
	 */
	public List<Role> findAll(){
		List<Role> roles = new ArrayList<Role>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from roles";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				//Can access data in cells via column index or name
				Role temp = new Role(rs.getInt(1), rs.getString("Title"));
				roles.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
	
	public Role getById(int id){
		Role r = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from roles where RId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				r = new Role();
				r.setId(rs.getInt(1));
				r.setTitle(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	//Insert data w/ prepared statements
	//When adding or updating data, we must take into account TRANSACTION MANAGEMENT
	//We must commit!
	//With connections, upon closing them, by default there is an autoCommit property
	//that can be set to true. We may want to turn this off to make sure that we handle any issues
	//that may arise during the transaction before we commit
	public Role save(String title){
		Role r = new Role();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into roles(Title) values(?)";
			// Create string array holding names of cols that are auto generated
			String[] keys = {"RId"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, title);
			//Queries return resultSet
			//Updates return ints of num of rows effected
			int numRows = ps.executeUpdate();
			if(numRows > 0){
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				r.setId(pk.getInt(1));
				r.setTitle(title);
				conn.commit(); // Commit your changes!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public Role update(Role r){
		//Param passed in will contain id of entity to be changed with the new values to change it to
		//Update Roles to set title = ? where RId = ?;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "UPDATE Roles SET title = ? WHERE RId = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, r.getTitle());
			ps.setInt(2, r.getId());
			
			int numRows = ps.executeUpdate();
			
			if(numRows > 0){
				conn.commit();
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
}
