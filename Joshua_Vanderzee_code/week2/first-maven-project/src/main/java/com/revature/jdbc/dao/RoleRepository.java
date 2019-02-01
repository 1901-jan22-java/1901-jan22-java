package com.revature.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.jdbc.ConnectionFactory;
import com.revature.jdbc.pojos.Roles;

public class RoleRepository {
	
	final static Logger logger = Logger.getLogger(RoleRepository.class);
	
	public List<Roles> findAll()
	{
		List<Roles> roles = new ArrayList<Roles>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from Revature_Roles";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next())
			{
				System.out.println("in while loop "  + rs.getString(2));
				Roles temp = new Roles(rs.getInt(1), rs.getString(2));
				roles.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
	
	
	public Roles getByID(int id) {
		Roles r = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from Revature_Roles where RoleID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet info =  ps.executeQuery();
			if (info.next())
			{
				r = new Roles(info.getInt(1), info.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public Roles save(String title) {
		Roles r = new Roles();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into revature_roles(RoleTitle) values (?)";
			String[] keys = {"RoleID"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1 ,title);
			
			int numRows = ps.executeUpdate();
			if (numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				r.setId(pk.getInt(1));
				r.setTitle(title);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public Roles Update(Roles r) {
		// update Revature_Roles set title = ? where RoleID = ?
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update Revature_Roles set RoleTitle = ? where RoleID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getTitle());
			ps.setInt(2, r.getId());
			int numRows = ps.executeUpdate();
			if (numRows > 0) {
				logger.info("Update complete");
				conn.commit();
			}
			else {
				logger.info("No row to update.");
				return null;				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return r;
	}
}
