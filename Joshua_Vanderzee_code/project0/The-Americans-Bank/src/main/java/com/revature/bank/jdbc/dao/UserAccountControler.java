package com.revature.bank.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.revature.bank.jdbc.ConnectionFactory;
import com.revature.bank.jdbc.pojos.User;

public final class UserAccountControler {
	
	private UserAccountControler() {}
	
	private static int loginAtempt = 0;
	private static String emailAlert = "";
	
	static int getLoginAtempt() {
		return loginAtempt;
	}

	static String getEmailAlert() {
		return emailAlert;
	}

	private static String hashString(String str) {
		String saltedhash = "n0w" + str.hashCode() + "$@1ted";
		String CompleteHash = saltedhash.hashCode() + "";
		return CompleteHash;
	}
	
	public static boolean Login(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call login(?, ?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, username);
			ps.setString(2, hashString(password));
			ps.registerOutParameter(3, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			int output = ps.getInt(3);
			System.out.println(output);
			if (output != 0)
				return true;
			if (loginAtempt++ >= 4) 
			{
				emailAlert = ps.getString(4);
			}
		} catch (SQLException e) {
			String[] cause = e.toString().split("\n");
			String[] message = cause[0].split(":");
			String result = message[2].trim();
			if (result.equals("no data found"))
			{
				System.out.println("Username/Password did not match. ");
			}
			else
				System.out.println(result);
		}
		
		return false;
	}
	
	
	
	public static boolean CreateAccount(User user) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call CreateAccount(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			
			ps.setString(1, user.getUserName());
			ps.setString(2, hashString(user.getPassword()));
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getSecurityQuestion1());
			ps.setString(6, user.getSecurityAnswer1());
			ps.setString(7, user.getSecurityQuestion2());
			ps.setString(8, user.getSecurityAnswer2());
			ps.setString(9, user.getSecurityQuestion3());
			ps.setString(10, user.getSecurityAnswer3());
			ps.setString(11, user.getAddressline1());
			ps.setString(12, user.getAddressline2());
			ps.setString(13, user.getCity());
			ps.setString(14, user.getStates());
			ps.setString(15, user.getCountry());
			ps.setString(16, user.getPostalCode() + "");
			ps.setString(17, user.getHomePhone() + "");
			ps.setString(18, user.getCellPhone() + "");
			ps.setString(19, user.getFax() + "");
			ps.setString(20, user.getEmail());
			ps.setInt(21, user.getSSN());
			ps.setDate(22, (Date) user.getBirthDate());
			ps.setString(23, user.getMaritalstatus());
			
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			String[] cause = e.toString().split("\n");
			String[] message = cause[0].split(":");
			String result = message[2].trim();
			if (result.equals("no data found"))
			{
				System.out.println("Username/Password did not match. ");
			}
			else
				System.out.println(result);
		}
		
		return false;
	}
}
