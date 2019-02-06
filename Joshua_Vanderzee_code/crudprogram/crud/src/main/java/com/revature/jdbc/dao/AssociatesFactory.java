package com.revature.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.revature.jdbc.ConnectionFactory;
import com.revature.jdbc.pojos.Associate;

public final class AssociatesFactory {
	
	private static String hashString(String str) {
		String saltedhash = "n0w" + str.hashCode() + "$@1ted";
		String CompleteHash = saltedhash.hashCode() + "";
		return CompleteHash;
	}
	
	public static long CreateAccount(Associate account) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call createAssociate(?, ?, ?, ?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, account.getFirstname());
			ps.setString(2, account.getLastname());
			ps.setString(3, account.getEmail());
			ps.setString(4, hashString(account.getPassword()));
			ps.setString(5, account.getGrade());
			ps.registerOutParameter(6, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			conn.commit();
			account.setId(ps.getLong(6));
			return account.getId();
		} catch (SQLIntegrityConstraintViolationException e) {
			return 0;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	public static long Login(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call login(?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, username);
			ps.setString(2, hashString(password));
			ps.registerOutParameter(3, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			return ps.getLong(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
     	return -1;
	}
	
}
