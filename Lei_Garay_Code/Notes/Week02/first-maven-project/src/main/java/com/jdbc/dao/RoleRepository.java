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
	
	
	/*
	 * PREAPARED STATEMENT
	 * - extends statement 
	 * - executes a pre-compiled SQL statement 
	 * - efficient for statements that will 
	 * execute multiple times and have variables
	 */
	
	public Role getById(int id) {
		Role r = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query =
					"select * from roles where rid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				r = new Role();
				r.setId(rs.getInt(1));
				r.setTitle(rs.getString(2));
			}
			else return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	// INSERT DATA W PREPARED STATEMENTS 
	public Role save(String title) {
		Role r = new Role();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			/*
			 * When adding or updating data, we must
			 * take into account TRANSACTION MANAGEMENT!
			 * we must commit!
			 * With connections, upon closing them, by
			 * default there is an autoCommit property
			 * that is set to true. We may want to turn this
			 * off to make sure that we handle any issues 
			 * that may arise during the TX before we commit
			 */
			conn.setAutoCommit(false);
			String sql = "insert into Roles(Title) values(?)";
			//create String array holding names of cols that are auto generated
			String[] keys = {"rid"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, title);
			
			//QUERIES return ResultSet
			//UPDATES return int of num rows affected
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				r.setId(pk.getInt(1));
				r.setTitle(title);
				conn.commit(); //COMMIT YOUR CHANGES IF THEYRE SUCCESSFUL!
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

}
