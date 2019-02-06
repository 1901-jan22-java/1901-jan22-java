package com.ravature.bank.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jdbc.util.ConnectionFactory;
import com.ravature.bank.pojos.Account;
import com.ravature.bank.pojos.User;
import com.ravature.bank.views.AccountView;
public class AccountRepository {
	public static List<Account> getAccounts(String username) {
		List<Account> accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from accounts where userid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account acc1 = new Account();
				acc1.setAccountId(rs.getInt(1));
				acc1.setAccountType(rs.getString(2));
				acc1.setBalance(rs.getDouble(3));
				acc1.setUserId(rs.getInt(4));
				accounts.add(acc1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
public static double getBalance(int User_Id){
	   Account a = null;
	   try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		   String query = "select * from accounts where userId = ?";
		   PreparedStatement ps = conn.prepareStatement(query);
		   ps.setInt(1, User_Id);
		   ResultSet rs = ps.executeQuery(); 
		   if(rs.next()) {
			   a = new Account();
			   a.setAccountId(rs.getInt(1));
			   a.setAccountType(rs.getString(2));
			   a.setBalance(rs.getDouble(3));
			   a.setUserId(rs.getInt(4));
			} 
	   } catch (SQLException e) {
		e.printStackTrace();
	}
	   return a.getBalance();
}
	public static Account save(Account newAccount, User loggedInUser) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "insert into accounts(user_id, account_type, balance) values (?, ?, ?)";
			String[] keys = { "account_id" };
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setInt(1, loggedInUser.getUser_Id());
			ps.setString(2, newAccount.getAccountType());
			ps.setDouble(3, 0d);
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				newAccount.setUserId(pk.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("You have Created a new Account");
		return newAccount;
	}
	public static void Deposit(int specificAccount, double depositAmount){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "update accounts set balance = balance + ? where accountId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1,  depositAmount);
			ps.setInt(2,  specificAccount);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static boolean Withdraw(int withdrawAccount, double withdrawAmount, User currUser){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "update accounts set balance = balance - ? where accountId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, withdrawAmount);
			ps.setInt(2, withdrawAccount);
			if(getBalance(currUser.getUser_Id()) - withdrawAmount < 0){
				System.out.println("Insuffient Funds");
				AccountView.initiateWithdrawal(currUser);
				return false;
			} else {
				ps.executeUpdate();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
}