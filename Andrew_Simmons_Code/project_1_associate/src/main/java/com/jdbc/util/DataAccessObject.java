package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessObject {
	
	public String[] login(String email, String pw) {
		String query = "SELECT * FROM ASSOCIATE WHERE email=? AND password = ?";
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new String[] {
					rs.getString("AID"), 		// rs.getString(1)
					rs.getString("FIRSTNAME"),	// rs.getString(2)
					rs.getString("LASTNAME"),	// rs.getString(3)
					rs.getString("EMAIL"),
					rs.getString("PASSWORD"),
					rs.getString("GRADE")
			};
		} catch (SQLException e) {
			//e.printStackTrace();
			
		}
			return null;
	}

	public void createAssociate(String fn, String ln, String email, String password) {
		String query = "INSERT INTO ASSOCIATE (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, GRADE) VALUES (?, ?, ?, ?, 0)";
		PreparedStatement ps;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			ps = conn.prepareStatement(query);
			ps.setString(1,fn);
			ps.setString(2,ln);
			ps.setString(3, email);
			ps.setString(4, password);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//String fn, String ln, String email, String password, int grade
	
	public void getAllAssociates() {
		
		  try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			  
			  String query = "SELECT * FROM ASSOCIATE";
			  Statement statement = conn.createStatement();
			  ResultSet rs = statement.executeQuery(query);
			  while(rs.next()) {
				  String firstname = rs.getString("FIRSTNAME");
				  System.out.println(firstname);
				  String lastname = rs.getString("LASTNAME");
				  System.out.println(lastname);
				  String eml = rs.getString("EMAIL");
				  System.out.println(eml);
				  String pw = rs.getString("PASSWORD");
				  System.out.println(pw);
				  String grades = rs.getString("GRADE");
				  System.out.println(grades);
			  }
			  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	        	
	
		
		
		
	
		
		
		
	}
	
	public void updateAssociateGrade(int grade, int aid) {
		
		   try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
	            conn.setAutoCommit(false);
	            String sql = "UPDATE ASSOCIATE set grade = ? WHERE aid = ?";
	            
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, grade);
	            ps.setInt(2,aid);
	            ps.executeUpdate();
	            
		   } catch (SQLException e) {
			e.printStackTrace();
		}
	            
	}
		
	
	
	public static void main(String[] args) {
		DataAccessObject dao = new DataAccessObject();
		dao.updateAssociateGrade(100, 8);
	}

}
