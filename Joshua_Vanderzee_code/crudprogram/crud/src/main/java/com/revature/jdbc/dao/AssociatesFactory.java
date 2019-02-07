package com.revature.jdbc.dao;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

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
	
	public static Associate Login(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call login(?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, hashString(password));
			cs.registerOutParameter(3, java.sql.Types.NUMERIC);
			cs.executeUpdate();
			long index = cs.getLong(3);
			
			sql = "select * from Associates where a_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, index);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				System.out.println("Results: " + rs.getString(4));

			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
     	return null;
	}
	
}
