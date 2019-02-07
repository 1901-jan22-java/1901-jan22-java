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

import com.revature.associate.Associate;
import com.revature.app.App;
import com.jdbc.utils.ConnectionFactory;

public class AssociateRepository {
	
	final static Logger logger = Logger.getLogger(AssociateRepository.class);
	
	public Associate getAssociate(String email) {
		Associate asc = new Associate();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Associates WHERE email = ?";
			String[] keys = {"associate_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			logger.info(email);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				logger.info("Result set exists");
				asc.setFirstname(rs.getString("firstname"));
				asc.setLastname(rs.getString("lastname"));
				asc.setEmail(rs.getString("email"));
				asc.setPassword(rs.getString("password"));
				asc.setGrade(rs.getDouble("grade"));
				asc.setId(rs.getInt("associate_id"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return asc;
	}
	
	public Associate updateGrades(Associate asc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "{call update_grade(?,?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, asc.getId());
			cs.setDouble(2,  asc.getGrade());
			
			
			cs.execute();
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return asc;
	}
	
	
}
