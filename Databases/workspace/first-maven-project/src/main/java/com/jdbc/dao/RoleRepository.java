package com.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jdbc.pojos.Role;
import com.jdbc.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class RoleRepository {
	
	final static Logger logger = Logger.getLogger(RoleRepository.class);
	
	
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
	
	public Role update(Role r) { //1, "something random"
		//param passed in will contain id of entity to be 
		//changed WITH the new values to change it to
		
		//update Roles set title = ? where rid = ?;
		
		   try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
	            conn.setAutoCommit(false);
	            String sql = "UPDATE Roles SET title = ? WHERE rid = ?";
	            
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1,r.getTitle());
	            ps.setInt(2,r.getId());
	            
	            int numRows = ps.executeUpdate();
	            
	            if(numRows > 0) {
	            	logger.info("ROLE " + r.getTitle() + " UPDATED");
	                conn.commit();
	            } else {
	            	logger.info("NO ROLE UPDATED");
	                return null;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return r;
	}
	
	/*
	 *  CALLABLE STATEMENT
	 *  - extends PreparedStatement
	 *  - allows us to execute stored procedures
	 *  - must REGISTER our IN and OUT parameter
	 *  values and types
	 *  - IN params will be set using setter methods
	 *  inherited from PreparedStatement
	 *  can return 1 or many ResultSet objects
	 *  
	 *  
	 *  ResultSet
	 *   - Table of data representing a DB resultset
	 *   generated by executing a SQL stmt
	 *   Maintains a cursor pointing to the current 
	 *   row (however, it is initially positioned
	 *   before the first row). The RS.next() method
	 *   moves that cursor to each subsequent row until
	 *   there are no more rows (returns false)		 */
	
	public List<Role> getAll(){
		List<Role> roles = new ArrayList<Role>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{call getAllRoles(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				Role r = new Role(rs.getInt(1), rs.getString(2));
				roles.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

}
