package com.jdbc.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleTypes;

public class Data_Access_Obj {
	
	public String login(String user, String pw) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM PROJECT_0_CLIENT_DATA WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,user);
			ps.setString(2,pw);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString("USERID");
		} catch (SQLException e) {
			System.out.println("\nSorry, your credentials are invalid. Try again.");
		}
		return null;
	}
	
	public boolean doesUserExist(String user){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT USERNAME FROM PROJECT_0_CLIENT_DATA WHERE USERNAME = \'"+user+"\'";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean createAccount(String user, String pw, int acct_type) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "INSERT INTO PROJECT_0_CLIENT_DATA (USERNAME,PASSWORD,BALANCE,ACC_TYPE) "
							+ "VALUES (?,?,0,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,user);
			ps.setString(2,pw);
			ps.setInt(3,acct_type);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String[] getUserData(String userid) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT USERID,USERNAME,BALANCE,ACC_TYPE FROM PROJECT_0_CLIENT_DATA WHERE USERID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,userid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
		} catch (SQLException e) {
			e.printStackTrace();
		} return null;
	}
	
	public void updateAccount(String balance, String userid) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "UPDATE PROJECT_0_CLIENT_DATA SET BALANCE=? WHERE USERID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,balance);
			ps.setString(2,userid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void printAllUsers() {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{call GET_ALL_USERS(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) System.out.println(rs.getInt(1) + " : " + rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		printAllUsers();
	}
	
}
