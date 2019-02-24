package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.ConnectionFactory;
import com.revature.pojos.Account;
import com.revature.pojos.User;

public class AccountRepository {
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Bank_Account";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setBalance(rs.getBigDecimal("balance"));
				temp.setUserId(rs.getInt("user_id"));
				temp.setType(rs.getString("account_type"));
				temp.setAccountNum(rs.getInt("account_id"));
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return accounts;
		
	}
}
