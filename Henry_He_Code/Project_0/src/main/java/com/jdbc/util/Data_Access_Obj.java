package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data_Access_Obj {
		
	public void login(String user, String pw) {}
	
	public boolean doesUserExist(String user){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT USERNAME FROM PROJECT_0_CLIENT_DATA WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,user);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void createAccount(String user, String pw, int acct_type) {
		
	}
	
	public void updateAccount() {}
	
	
}
