package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.account.Account;
import com.jdbc.util.ConnectionFactory;

public class AccountRepository {
	//Insert data with prepares statements 
	public Account save(String type, int client, double amount) {
		Account acc = new Account(type, amount);
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Account(account_type, client_id, balance) VALUES(?,?,?)";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"account_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setString(1, type);
			ps.setInt(2, client);
			ps.setDouble(3, amount);
			
			
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				acc.setFirstname(pk.getString(1));
				acc.setLastname(pk.getString(2));
				conn.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
}
