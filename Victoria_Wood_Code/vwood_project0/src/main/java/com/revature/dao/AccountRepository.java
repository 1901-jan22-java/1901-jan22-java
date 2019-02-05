package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.NoMoneyException;
import com.revature.pojos.Account;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;



public class AccountRepository {
	
	public static User logIn(String username, String pwd) {
		User c = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select*from Users where username = ? and pwd = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, pwd);
			ResultSet info = ps.executeQuery();
			if(info.next()) {
				c = new User(info.getInt("userid"), info.getString("firstname"), info.getString("lastname"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static User createNewAccount(String fn, String ln, String username, String pwd) {
		User c = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into Users(username, pwd, firstname, lastname) values( ?, ?, ?, ?)";
			String[] keys = {"uid"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, username); ps.setString(2, pwd); ps.setString(3, fn); ps.setString(4, ln);
			int numRows = ps.executeUpdate();
			if (numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				int c_id = pk.getInt(1);
				c = new User(c_id, fn, ln);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
	public static boolean isUniqueUsername(String username) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select username from Users";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("username").contentEquals(username)) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	public static Account addAccount(int uid, String type, float deposit) {
		Account a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into Account(type, balance, Userid) values(?, ?, ?)";
			String[] keys = {"acctid"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, type); ps.setFloat(2, deposit); ps.setInt(3, uid);
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				int a_id = pk.getInt(1);
				a = new Account(a_id, type, deposit, uid);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	
	public static int acctCount(int uid) {
		int c = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select count(*) from Account where userid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			ResultSet info = ps.executeQuery();
			if(info.next()) {
				c = info.getInt(1);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
	public static List<Account> getAccounts(int uid) {
		List<Account> accts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call getAccount(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, uid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()) {
				Account a = new Account(rs.getInt("acctid"), rs.getString("type"), rs.getFloat("balance"), uid);
				accts.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accts;
	}
	
	public static Account deposit(Account a, float deposit) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update Account set balance = ? where acctid = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, (a.getBalance() + deposit));
			ps.setInt(2, a.getId());
			int numRows = ps.executeUpdate();
			if (numRows > 0) {
				a.setBalance(a.getBalance() + deposit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	public static Account withdraw(Account a, float withdrawl) throws NoMoneyException {
		if (withdrawl > a.getBalance()) {
			throw new NoMoneyException("Your withdrawl exceeds the balance of this account.");
		} else {
			try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
				String sql = "update Account set balance = ? where acctid = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setFloat(1,  a.getBalance() - withdrawl);
				ps.setInt(2, a.getId());
				int numRows = ps.executeUpdate();
				if (numRows > 0) {
					a.setBalance(a.getBalance() - withdrawl);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
	
}
