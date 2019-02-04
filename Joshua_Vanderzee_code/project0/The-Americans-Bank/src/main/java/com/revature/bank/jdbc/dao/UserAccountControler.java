package com.revature.bank.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.bank.jdbc.ConnectionFactory;
import com.revature.bank.jdbc.pojos.User;

public final class UserAccountControler {
	
	private UserAccountControler() {}
	
	public static boolean Login(String username, String Password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call login(?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, username);
			String saltedhash = "n0w" + Password.hashCode() + "$@1ted";
			String CompleteHash = saltedhash.hashCode() + "";
			ps.setString(2, CompleteHash);
			ps.registerOutParameter(3, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			System.out.println(ps.getInt(3));
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
			String sql = "{call login(?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, username);
			String saltedhash = "n0w" + Password.hashCode() + "$@1ted";
			String CompleteHash = saltedhash.hashCode() + "";
			ps.setString(2, CompleteHash);
			ps.registerOutParameter(3, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			System.out.println(ps.getInt(3));
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
