package com.revature.bank.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.jdbc.ConnectionFactory;
import com.revature.bank.jdbc.pojos.Account;
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
	
	public static boolean CreateAccount(long id, Account account) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call add_Acount(?, ?, ?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setLong(1, id);
			ps.setString(2, account.getAccountType());
			ps.setLong(3, account.getAccountNumber());
			ps.setLong(4, account.getRoutingNumber());
			ps.setDouble(5, account.getBalance());
			ps.executeUpdate();
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public static double Deposite(long id, long amount) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call Deposit(?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setLong(1, id);
			ps.setDouble(2, amount);
			ps.registerOutParameter(3, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			conn.commit();
			return ps.getDouble(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static long Withdraw(long id, long amount) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call Withdraw(?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setLong(1, id);
			ps.setDouble(2, amount);
			ps.registerOutParameter(3, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			conn.commit();
			return ps.getLong(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	public static List<Account> findAllAccounts(long id)
	{
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from UserAccounts where UserID = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			System.out.println(rs.toString());
			while(rs.next())
			{
				System.out.println(rs.getLong(1) + " " + rs.getString(2));
				query = "select * from Accounts where AccountId = ?";
				statement = conn.prepareStatement(query);
				statement.setLong(1, rs.getLong(2));
				ResultSet rs2 = statement.executeQuery();
				rs2.next();
				Account temp = new Account(rs2.getLong(1), rs2.getString(2), rs2.getLong(3), rs2.getLong(4), rs2.getLong(5));
				accounts.add(temp);
			}
			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Account>();
		}
	}
	
	public static long Login(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call login(?, ?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, username);
			ps.setString(2, hashString(password));
			ps.registerOutParameter(3, java.sql.Types.NUMERIC);
			ps.registerOutParameter(4, java.sql.Types.VARCHAR);
			ps.executeUpdate();
			long output = ps.getLong(3);
			System.out.println(output);
			switch ((int)output) {
				case 0:
					if (++loginAtempt >= 4) 
					{
						System.out.println(ps.getString(4));
						emailAlert = ps.getString(4);
						Thread.sleep(2000);
					}
					return 0;
				case -1 :
			     	return -1;
				default:
					return output;
			}
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
     	return -1;
	}
	
	
	
	public static boolean CreateUser(User user) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call CreateAccount(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
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
			ps.setNString(21, user.getSSN() + "");
			ps.setDate(22, (Date) user.getBirthDate());
			ps.setString(23, user.getMaritalstatus());
			ps.registerOutParameter(24, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			user.setUserId(ps.getLong(24));
			return user.getUserId() != -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
