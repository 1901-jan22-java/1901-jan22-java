package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAccessObject {

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
	
	public static void main(String[] args) {
		DataAccessObject dao = new DataAccessObject();
		dao.createAssociate("ohgod", "pleasehelp", "Imdying", "thisishell");
	}

}
